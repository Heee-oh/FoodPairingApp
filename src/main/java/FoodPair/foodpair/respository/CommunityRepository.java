package FoodPair.foodpair.respository;

import FoodPair.foodpair.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<Post, Integer> {
    @Modifying
    @Query("update community set viewCount = viewCount + 1 where id = :id")
    void updateViews(@Param("id") int id);


}
