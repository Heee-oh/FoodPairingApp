package FoodPair.foodpair.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Comment {

    @Id @Column(name = "comment_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    @Column(name = "parent_id")
    private Integer parentId;
    @Column(name = "post_id")
    private Integer postId;
    private Long uuid;
    private String content;


    public Comment() {
    }

}
