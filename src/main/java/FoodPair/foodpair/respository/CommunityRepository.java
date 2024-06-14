package FoodPair.foodpair.respository;

import FoodPair.foodpair.domain.Post;
import FoodPair.foodpair.domain.PostDto;
import FoodPair.foodpair.domain.UpdatePostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Post, Integer> {


    // 본인 작성 글 조회
    List<Post> findPostsByUuid(long uuid);

    // 조회수 업데이트
    @Modifying
    @Query("update community set viewCount = viewCount + 1 where id = :id")
    void updateViews(@Param("id") int id);

    // 좋아요 +1 - 1
    @Modifying
    @Query("update community set likeConut = likeConut + :value where id= :id")
    void updateLikeCount(@Param("value") int value, @Param("id") int id);

    // 댓글 +1 -1
    @Modifying
    @Query("update community set commentConut = commentConut + :value where id= :id")
    void updateCommentCount(@Param("value") int value, @Param("id") int postId);

    // 좋아요 체크 테이블에 생성
    @Modifying
    @Query(value = "insert into check_like (post_id, uuid, like_check) values (:id, :uuid, :check)", nativeQuery = true)
    void checkLike(@Param("id") int id, @Param("uuid") long uuid, @Param("check") boolean check);

    // 체크테이블 업데이트
    @Modifying
    @Query(value = "update check_like set like_check = :tf where post_id=:id and uuid=:uuid", nativeQuery = true)
    void updateLike(@Param("id") int id, @Param("uuid") long uuid, @Param("tf") int value);


    @Query(value = "select like_check from check_like where post_id=:id and uuid=:uuid", nativeQuery = true)
    Integer findCheckLikeById(int id, long uuid);

    @Modifying
    @Query(value = "update community set content = :content where post_id=:id", nativeQuery = true)
    void updatePost(@Param("id") int id, @Param("content") String content);

}
