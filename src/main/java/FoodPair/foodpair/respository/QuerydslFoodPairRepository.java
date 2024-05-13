package FoodPair.foodpair.respository;

import FoodPair.foodpair.domain.Member;
import FoodPair.foodpair.domain.Post;
import FoodPair.foodpair.domain.UpdatePostDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static FoodPair.foodpair.domain.QPost.post;

@Repository
@Transactional
public class QuerydslFoodPairRepository implements FoodPairRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;

    public QuerydslFoodPairRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }


    @Override
    public void addLikePost() {

    }

    @Override
    public void updateCommentCount() {

    }
}
