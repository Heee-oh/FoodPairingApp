package FoodPair.foodpair.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;


@Entity
@Getter
public class Member {

    @Id
    private Long uuid;
    private String nickname;
    @Column(name = "favorite_drink")
    private String favoriteDrink;
    @Column(name = "signup_date")
    private Timestamp signupDate;


    public Member() {
    }

    public Member(Long uuid, String nickname, String favorite_drink, Timestamp signupDate) {
        this.uuid = uuid;
        this.nickname = nickname;
        this.favoriteDrink = favorite_drink;
        this.signupDate = signupDate;
    }

    private void setFavorite_drink(String favoriteDrink) {
        this.favoriteDrink = favoriteDrink;
    }
}
