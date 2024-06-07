package FoodPair.foodpair.web;

import FoodPair.foodpair.domain.JwtTokenProvider;
import FoodPair.foodpair.domain.KakaoApi;
import FoodPair.foodpair.domain.ResponseCode;
import FoodPair.foodpair.domain.User;
import FoodPair.foodpair.respository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;


@Slf4j
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class UserController {

    private final KakaoApi kakaoApi;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @PostMapping("/Auth")
    public ResponseEntity<?> kakaoLoginAuth(@RequestBody HashMap<String, String> request, HttpServletResponse response) {

        log.info("code={}", request.get("code"));
        String accessToken = kakaoApi.getAccessToken(request.get("code"));

        log.info("accessToken={}", accessToken);

        // authCheck 메소드를 통해 JWT를 생성하고 쿠키에 저장
        authCheck(accessToken, response);

        // 성공 응답 반환
        return ResponseEntity.ok().body("login successful");
    }

    private void authCheck(String accessToken, HttpServletResponse response) {
        Long Uuid = kakaoApi.getUserUuid(accessToken);
        User user = userRepository.findById(Uuid).orElse(null);

        if (user == null) {
             user = userRepository.save(new User(Uuid, (String) kakaoApi.getUserInfo(accessToken).get("nickname"), ""));

        }

        // JWT 생성
        String token = jwtTokenProvider.createToken(user.getUuid().toString());

        // 쿠키 생성 및 설정
        Cookie cookie = new Cookie("access_Token", token);
        log.info("cookie={}", cookie.getValue());
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24);

        // 쿠키를 응답에 추가
        response.addCookie(cookie);
    }


}
