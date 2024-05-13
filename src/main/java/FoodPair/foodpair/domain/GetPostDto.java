package FoodPair.foodpair.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class GetPostDto {

    private Post post;
    private List<Comment> comments;

    public GetPostDto(Post post, List<Comment> comments) {
        this.post = post;
        this.comments = comments;
    }
}
