package FoodPair.foodpair.service;

import FoodPair.foodpair.domain.Wine;
import FoodPair.foodpair.respository.WineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WineService {


    private final WineRepository wineRepository;

    public List<Wine> findWinesByPairingFood(String pairingFood) {
        return wineRepository.findByPairingFood(pairingFood);
    }
}
