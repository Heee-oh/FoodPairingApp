package FoodPair.foodpair.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "wine")
public class Wine {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wineId;


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


    @Override
    public String toString() {
        return "Wine{" +
                "wineId=" + wineId +
                ", name='" + name + '\'' +
                ", imageSrc='" + imageSrc + '\'' +
                ", description='" + description + '\'' +
                ", pairingFood='" + food + '\'' +
                ", note='" + note + '\'' +
                '}';

    }
}
