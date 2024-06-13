package FoodPair.foodpair.respository;

import FoodPair.foodpair.domain.PostDto;
import FoodPair.foodpair.domain.Wine;

import java.util.List;

public interface FoodPairRepository {
    List<Wine> findPairingWine(String foodName);

    List<Wine> findDefaultWines();
    public List<PostDto> findAllPostsWithWine();

}