package FoodPair.foodpair.respository;

import FoodPair.foodpair.domain.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineRepository extends JpaRepository<Wine, Integer> {
    List<Wine> findByPairingFood(String pairingFood);
}