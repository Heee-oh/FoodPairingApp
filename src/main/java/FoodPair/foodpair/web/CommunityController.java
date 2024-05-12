package FoodPair.foodpair.web;

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

    @GetMapping("/post/{postId}")
    public Optional<Post> postDetail(@PathVariable long postId) {
        return postService.findById(postId);
    }

    @PostMapping("/post/{postId}")
    public Post updatePost(@PathVariable long postId, @RequestBody UpdatePostDto updatePostDto) {
        return postService.update(postId, updatePostDto);
    }

    @DeleteMapping("/post/{postId}")
    public HttpEntity<String> deletePost(@PathVariable long postId) {
        postService.delete(postId);
        return new ResponseEntity<>("삭제 완료", HttpStatus.OK);
    }

    @GetMapping("/post")
    public List<Post> findPosts() {
        return postService.findAllPost();
    }




}
