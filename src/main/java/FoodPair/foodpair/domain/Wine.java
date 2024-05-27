package FoodPair.foodpair.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Wine {

    @Id @Column(name = "wine_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "image_src")
    private String imageSrc;

    @Column(name = "description")
    private String description;
    @Column(name = "pairing_food")
    private String food;
    @Column(name = "note")
    private String note;


    public Wine() {

    }
}
