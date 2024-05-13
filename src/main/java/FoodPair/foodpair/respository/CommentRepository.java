package FoodPair.foodpair.respository;

import FoodPair.foodpair.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    // 게시글 삭제시 모든 댓글 삭제
    void deleteCommentsByPostId(Integer postId);

    // 특정 댓글 삭제
    void deleteCommentByCommentId(Integer commentId);

    // 해당 게시물의 댓글 전부 조회
    List<Comment> findCommentsByPostId(Integer postId);

}
