package FoodPair.foodpair.service;

import FoodPair.foodpair.domain.Comment;
import FoodPair.foodpair.domain.JwtTokenProvider;
import FoodPair.foodpair.domain.Post;
import FoodPair.foodpair.domain.UpdatePostDto;
import FoodPair.foodpair.respository.CommentRepository;
import FoodPair.foodpair.respository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceV2 implements PostService {
    private final CommunityRepository communityRepository;
    private final CommentRepository commentRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public Post save(Post post, long id) {
        post.setDefaultValue(id);
        return communityRepository.save(post);
    }

    @Override
    public Optional<Post> findById(int postId) {
        communityRepository.updateViews(postId);
        return communityRepository.findById(postId);
    }

    @Override
    public List<Post> findAllPost() {
        return communityRepository.findAll();
    }

    @Override
    public void delete(int id) {
        commentRepository.deleteCommentsByPostId(id);
        communityRepository.delete(findById(id).get());
    }

    // 고민해볼 것
    // 무결성과 일관성 유지를 위해서 변경된 부분만 확인하여 업데이트할 것인지
    // 그대로 덮어씌워서 처리속도를 높일 것인지
    // 변경된 부분 체크일 경우
    // 프론트단에서 값을 입력받을때 상태 비트를 같이 보내준다.
    // 이로써 비트에 해당하는 속성만 변경하도록 로직을 짠다.
    @Override
    public void update(int postId, UpdatePostDto updatePostDto) {
        updatePostDto.setCreateAt(LocalDateTime.now());
        communityRepository.updatePost(postId, updatePostDto.getContent(), updatePostDto.getAnonStatus(), updatePostDto.getWineId());
    }

    /**
     * Comment Part
     */

    @Override
    public Comment save(Comment comment, int postId) {
        communityRepository.updateCommentCount(1, postId);
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findComments(int postId) {
        return commentRepository.findCommentsByPostId(postId);
    }

    @Override
    public void deleteCommentById(int commentId, int postId) {
        communityRepository.updateCommentCount(-1, postId);
        commentRepository.deleteCommentByCommentId(commentId);
    }

    /**
     * Like Part
     */

    // uuid를 jwt토큰에서 추출해서 사용해야함

    @Override
    public void updateLikeCount(int id) {
        Integer check = communityRepository.findCheckLikeById(id, 2);
        if (check == null) {
            checkLike(id, 2, true);
            communityRepository.updateLikeCount(1, id);
            log.info("없어서 새로 생성 ");
            return;
        }

        if (check == 1) {
            communityRepository.updateLikeCount(-1, id);
            updateLike(id, 2, 0);
            log.info("있어서 false로 바꾸고 -1 ");
            return;
        }
        log.info("false에서 true +1");
        communityRepository.updateLikeCount(1, id);
        updateLike(id, 2, 1);
    }

    // 좋아요 체크 테이블 생성
    @Override
    public void checkLike(int id, long uuid, boolean check) {
        communityRepository.checkLike(id, uuid, check);
    }

    @Override
    public void updateLike(int id, long uuid, int value) {
        communityRepository.updateLike(id, uuid, value);
    }

    // 게시글 좋아요 했는지 여부 반환
    @Override
    public boolean findCheckLikeById(int id, long uuid) {
        int value = communityRepository.findCheckLikeById(id, uuid);

        return value == 1 ? true : false;
    }


}
