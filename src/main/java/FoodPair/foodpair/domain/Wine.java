package FoodPair.foodpair.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Wine {

    @Id @Column(name = "wine_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "image_src")
    private String imageSrc;
    private String description;
    @Column(name = "pairing_food")
    private String food;


    public Wine() {
    }
}
