package FoodPair.foodpair.service;

import FoodPair.foodpair.domain.Member;
import FoodPair.foodpair.domain.Post;
import FoodPair.foodpair.domain.UpdatePostDto;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Member save(Member member);

    Post save(Post post);

    Optional<Post> findById(long id);

    List<Post> findAllPost();

    void delete(long id);

    Post update(long postId, UpdatePostDto updatePostDto);
}
