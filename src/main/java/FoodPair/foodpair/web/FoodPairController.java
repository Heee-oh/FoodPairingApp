package FoodPair.foodpair.web;

import FoodPair.foodpair.domain.Wine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("")
public class FoodPairController {


    // 음식 종류와 음식 사진의 경로를 알아야됌
    // 아니면 프론트에서 따로 사진 저장 후 페어링 모델에 보내고,
    // 여기서는 음식 종류를 받고 wine 객체를 반환

    @PostMapping("/wine/{foodName}")
    public Wine pairing(@PathVariable String foodName) {

        return null;
    }
}
