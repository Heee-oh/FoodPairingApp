package FoodPair.foodpair.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Getter
public class User implements UserDetails {

    @Id
    private Long uuid;
    private String nickname;
    @Column(name = "favorite_drink")
    private String favoriteDrink;
    @Column(name = "signup_date")
    private LocalDateTime createAt;

    @ElementCollection(fetch = FetchType.EAGER) //roles 컬렉션
    private List<String> roles = new ArrayList<>();


    public User() {
    }

    public User(Long uuid, String nickname, String favoriteDrink) {
        this.uuid = uuid;
        this.nickname = nickname;
        this.favoriteDrink = favoriteDrink;
        this.createAt = LocalDateTime.now();
    }

    private void setFavorite_drink(String favoriteDrink) {
        this.favoriteDrink = favoriteDrink;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return uuid.toString();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


