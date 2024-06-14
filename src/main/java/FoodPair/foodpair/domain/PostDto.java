package FoodPair.foodpair.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;


@Getter
@Slf4j
public class PostDto {


    private Post post;
    private Wine wine;
    private User user;

    public PostDto(Post post, Wine wine, User user) {
        this.post = post;
        this.wine = wine;
        this.user = user;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "post=" + post +
                ", wine=" + wine +
                ", user=" + user +
                '}';
    }
}
