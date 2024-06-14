package FoodPair.foodpair.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class GetPostDto {

    private User user;
    private Post post;
    private List<Comment> comments;

    public GetPostDto(User user, Post post, List<Comment> comments) {
        this.user = user;
        this.post = post;
        this.comments = comments;
    }
}
