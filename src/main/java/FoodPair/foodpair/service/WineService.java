package FoodPair.foodpair.service;

import FoodPair.foodpair.domain.Wine;
import FoodPair.foodpair.respository.QuerydslFoodPairRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WineService {

    private final QuerydslFoodPairRepository querydslFoodPairRepository;
    public List<Wine> findWinesByPairingFood(String pairingFood) {
        List<Wine> wines = querydslFoodPairRepository.findPairingWine(pairingFood);
        return wines.isEmpty() ? querydslFoodPairRepository.findDefaultWines() : wines;
    }
}
