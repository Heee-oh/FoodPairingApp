package FoodPair.foodpair.web;

import FoodPair.foodpair.domain.Wine;
import FoodPair.foodpair.respository.QuerydslFoodPairRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("")
public class FoodPairController {

    private final QuerydslFoodPairRepository foodPairRepository;

    @Autowired
    public FoodPairController(QuerydslFoodPairRepository foodPairRepository) {
        this.foodPairRepository = foodPairRepository;
    }

    // 음식 종류와 음식 사진의 경로를 알아야됌
    // 아니면 프론트에서 따로 사진 저장 후 페어링 모델에 보내고,
    // 여기서는 음식 종류를 받고 wine 객체를 반환


    @GetMapping("/wine/{foodName}")
    @ResponseBody
    public List<Wine> pairing(@PathVariable String foodName) {
        List<Wine> pairedWine = foodPairRepository.findPairingWine(foodName);
        if (pairedWine.isEmpty()) {
            return foodPairRepository.findDefaultWines();
        }
        return pairedWine;
    }

}