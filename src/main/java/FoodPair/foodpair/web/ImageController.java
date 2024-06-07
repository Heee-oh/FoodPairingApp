package FoodPair.foodpair.web;


import FoodPair.foodpair.domain.Image;
import FoodPair.foodpair.domain.Wine;
import FoodPair.foodpair.service.ImageService;
import FoodPair.foodpair.service.WineService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("")
public class ImageController {


    private RestTemplate restTemplate;
    private WineService wineService;
    private final ImageService imageService;

    @PostMapping("/upload")
    public Image uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        return imageService.saveImage(file);
    }
    @PostMapping("/uploads")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
        // 파이썬 서버로 이미지 전송
        String pythonServerUrl = "http://172.17.152.143:5000/predict";

        try {
            // 파일 이름 로그 출력
            System.out.println("Uploading file: " + file.getOriginalFilename());

            // MultipartFile을 ByteArrayResource로 변환
            ByteArrayResource imageResource = new ByteArrayResource(file.getBytes()) {
                @Override
                public String getFilename() {
                    return file.getOriginalFilename();
                }
            };

            // HttpEntity 생성
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("image", imageResource);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            // 요청 전송 로그 출력
            System.out.println("Sending request to Python server...");

            // 파이썬 서버로 POST 요청 전송
            ResponseEntity<String> response = restTemplate.postForEntity(pythonServerUrl, requestEntity, String.class);

            // 응답 수신 로그 출력
            System.out.println("Received response from Python server: " + response.getStatusCode());

            // Python 서버로부터 받은 응답 본문 로그 출력
            System.out.println("Response body from Python server: " + response.getBody());

            // ObjectMapper 인스턴스 생성
            ObjectMapper objectMapper = new ObjectMapper();

            // response.getBody()로부터 predictedClass 추출
            String jsonBody = response.getBody();
            Map<String, String> responseBodyMap = objectMapper.readValue(jsonBody, new TypeReference<Map<String,String>>() {});
            String predictedClass = responseBodyMap.get("predicted_class");

            // 예측된 음식과 페어링되는 와인 리스트 조회 로직 구현
            List<Wine> wines = wineService.findWinesByPairingFood(predictedClass);

            // 조회된 와인 정보 로그 출력
            System.out.println("Pairing wines:");
            for (Wine wine : wines) {
                System.out.println(wine);
            }

            // 조회된 와인 정보를 프론트엔드로 응답
            return new ResponseEntity<>(wines, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to send image to Python server", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/image")
    public List<Image> findImages() {return imageService.findAllImage();}
}