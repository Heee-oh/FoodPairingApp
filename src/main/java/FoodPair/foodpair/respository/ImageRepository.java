package FoodPair.foodpair.respository;


import FoodPair.foodpair.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}