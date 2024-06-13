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


    public PostDto(Post post, Wine wine) {
        this.post = post;
        this.wine = wine;
    }

    @Override
    public String toString() {
        log.info("post={}", post);
        log.info("wine={}", wine);
        return "PostDto{" +
                "post=" + post +
                ", wine=" + wine +
                '}';
    }
}
