package FoodPair.foodpair.respository;

import FoodPair.foodpair.domain.Member;
import FoodPair.foodpair.domain.Post;
import FoodPair.foodpair.domain.UpdatePostDto;

import java.util.List;
import java.util.Optional;

public interface FoodPairRepository {

    Member save(Member member);

    Post save(Post post);

    Optional<Post> findById(long id);

    List<Post> findAllPost();

    void deletePost(long id);

    Post update(long postId, UpdatePostDto updatePostDto);
    public void updateViews(Long id);

}
