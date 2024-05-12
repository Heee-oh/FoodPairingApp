package FoodPair.foodpair.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "community")
@Getter @Setter
public class Post {
    @Id @Column(name = "post_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long uuid;
    @Column(name = "view_count")
    private Integer viewCount;
    @Column(name = "comment_count")
    private Integer commentConut;
    @Column(name = "like_count")
    private Integer likeConut;

    private String content;
    @Column(name = "image_src")
    private String imageSrc;
    @Column(name = "anon_status")
    private Boolean anonStatus;
    @Column(name = "wine_id")
    private Integer wineId;
    @Column
    private LocalDateTime createAt;

    public Post() {
    }


}
