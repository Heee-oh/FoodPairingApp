package FoodPair.foodpair.service;

import FoodPair.foodpair.domain.Comment;
import FoodPair.foodpair.domain.Member;
import FoodPair.foodpair.domain.Post;
import FoodPair.foodpair.domain.UpdatePostDto;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Member save(Member member);

    Post save(Post post);

    Optional<Post> findById(int id);

    List<Post> findAllPost();

    void delete(int id);

    Post update(long postId, UpdatePostDto updatePostDto);

    Comment save(Comment comment, int postId);

    List<Comment> findComments(int id);

    void deleteCommentById(int commentId, int postId);
}
