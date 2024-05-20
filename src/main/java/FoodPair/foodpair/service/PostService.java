package FoodPair.foodpair.service;

import FoodPair.foodpair.domain.Comment;
import FoodPair.foodpair.domain.Post;
import FoodPair.foodpair.domain.UpdatePostDto;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post save(Post post);
    Optional<Post> findById(int id);
    List<Post> findAllPost();
    void delete(int id);
    void update(int postId, UpdatePostDto updatePostDto);
    Comment save(Comment comment, int postId);
    List<Comment> findComments(int id);
    void deleteCommentById(int commentId, int postId);
    void updateLikeCount( int id);
    void checkLike(int id, long uuid, boolean check);
    void updateLike(int id, long uuid, int value);
    boolean findCheckLikeById(int id, long uuid);
}
