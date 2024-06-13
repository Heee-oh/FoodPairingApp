package FoodPair.foodpair.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import FoodPair.foodpair.domain.Image;
import FoodPair.foodpair.respository.ImageRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ImageService {


    private final ImageRepository imageRepository;

    public Image saveImage(MultipartFile file) throws IOException {
        // 파일 저장 경로 설정
        String folder = "C:/Users/User/Desktop/foodpair/src/main/front/public/images/";
        File directory = new File(folder);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // 파일 이름 설정
        String filePath = folder + file.getOriginalFilename();
        File dest = new File(filePath);
        file.transferTo(dest);

        // 데이터베이스에 파일 경로 저장
        Image image = new Image();
        image.setFilePath("/images/" + file.getOriginalFilename());
        log.info("image={}", image);
        return imageRepository.save(image);
    }

    public List<Image> findAllImage(){return imageRepository.findAll();}
}