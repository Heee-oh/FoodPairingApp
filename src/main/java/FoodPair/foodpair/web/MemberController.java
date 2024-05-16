package FoodPair.foodpair.web;

import FoodPair.foodpair.domain.KakaoApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@Slf4j
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class MemberController {

    private final KakaoApi kakaoApi;
    @PostMapping("/Auth")
    public String aa(@RequestBody HashMap<String, String> request) {

        log.info("code={}", request.get("code"));
        String accessToken = kakaoApi.getAccessToken(request.get("code"));
//        HashMap<String, Object> userInfo = kakaoApi.getUserInfo(accessToken);
//        String userUuid = kakaoApi.getUserUuid(accessToken);

        log.info("accessToekn={}",accessToken);

        return "fadsfa";
    }



}
