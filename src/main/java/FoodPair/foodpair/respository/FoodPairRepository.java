package FoodPair.foodpair.respository;

import FoodPair.foodpair.domain.Member;
import FoodPair.foodpair.domain.Post;
import FoodPair.foodpair.domain.UpdatePostDto;

import java.util.List;
import java.util.Optional;

public interface FoodPairRepository {

    void addLikePost();

    void updateCommentCount();


}
