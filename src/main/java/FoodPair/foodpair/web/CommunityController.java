package FoodPair.foodpair.web;

import FoodPair.foodpair.domain.Comment;
import FoodPair.foodpair.domain.Post;
import FoodPair.foodpair.domain.UpdatePostDto;
import FoodPair.foodpair.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class CommunityController {

    private final PostService postService;

    @PostMapping("/savePost")
    public Post savePost(@RequestBody Post post) {
        return postService.save(post);
    }

    // detail의 경우 댓글과 post를 둘다 반환해야함
    // 새로운 domain을 만드는것을 고려

    @GetMapping("/post/{postId}")
    public Optional<Post> postDetail(@PathVariable int postId) {
        return postService.findById(postId);
    }

    @PostMapping("/post/{postId}")
    public Post updatePost(@PathVariable long postId, @RequestBody UpdatePostDto updatePostDto) {
        return postService.update(postId, updatePostDto);
    }

    @DeleteMapping("/post/{postId}")
    public HttpEntity<String> deletePost(@PathVariable int postId) {
        postService.delete(postId);
        return new ResponseEntity<>("삭제 완료", HttpStatus.OK);
    }

    @GetMapping("/post")
    public List<Post> findPosts() {
        return postService.findAllPost();
    }

    @PostMapping("/saveComent")
    public Comment save(@RequestBody Comment comment) {
        return postService.save(comment);
    }

    @GetMapping("/post/{postId}/comment")
    public List<Comment> findComments(@PathVariable int postId) {
        return postService.findComments(postId);
    }




}
