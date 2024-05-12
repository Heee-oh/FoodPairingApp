package FoodPair.foodpair.service;

import FoodPair.foodpair.domain.Comment;
import FoodPair.foodpair.domain.Member;
import FoodPair.foodpair.domain.Post;
import FoodPair.foodpair.domain.UpdatePostDto;
import FoodPair.foodpair.respository.FoodPairRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceV1 implements PostService {

    private final FoodPairRepository foodPairRepository;
    @Override
    public Member save(Member member) {
        return member;
    }

    @Override
    public Post save(Post post) {
        setDefaultpost(post);
        return foodPairRepository.save(post);
    }

    @Override
    public Comment save(Comment comment) {
        return null;
    }

    @Override
    public List<Comment> findComments(int id) {
        return null;
    }

    @Override
    public Optional<Post> findById(int id) {
        return foodPairRepository.findById(id);
    }

    @Override
    public List<Post> findAllPost() {
        return foodPairRepository.findAllPost();
    }

    @Override
    public void delete(int id) {
        foodPairRepository.deletePost(id);
    }

    @Override
    public Post update(long postId, UpdatePostDto updatePostDto) {
        return null;
    }


    // 고민해볼 것
    // 무결성과 일관성 유지를 위해서 변경된 부분만 확인하여 업데 이트할 것인지
    // 그대로 덮어씌워서 처리속도를 높일 것인지
    // 변경된 부분 체크일 경우
    // 프론트단에서 값을 입력받을때 상태 비트를 같이 보내준다.
    // 이로써 비트에 해당하는 속성만 변경하도록 로직을 짠다.


    public Post update(int postId, UpdatePostDto updatePostDto) {
        // 고민중
        return foodPairRepository.update(postId, updatePostDto);
    }

    private void setDefaultpost(Post post) {
        post.setCreateAt(LocalDateTime.now());
        post.setViewCount(0);
        post.setCommentConut(0);
        post.setLikeConut(0);
    }

}
