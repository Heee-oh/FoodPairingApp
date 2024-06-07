package FoodPair.foodpair.respository;

import FoodPair.foodpair.domain.QWine;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import FoodPair.foodpair.domain.Wine;

import java.util.List;

@Slf4j
@Repository
@Transactional
public class QuerydslFoodPairRepository implements FoodPairRepository {

    private final JPAQueryFactory query;

    public QuerydslFoodPairRepository(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public List<Wine> findPairingWine(String foodName) {
        // Querydsl을 이용하여 foodName에 맞는 와인을 검색하는 로직 추가
        // QWine은 QueryDSL을 이용하여 생성된 Wine 엔티티의 Q타입 클래스입니다.
        QWine qWine = QWine.wine;

        List<Wine> allWine = query.select(qWine)
                .from(qWine)
                .where(qWine.food.contains(foodName))
                .limit(3)
                .fetch();
        log.info("wine={}", allWine);
        return allWine;
    }

    @Override
    public List<Wine> findDefaultWines() {
        QWine qWine = QWine.wine;
        return query.selectFrom(qWine)
                .where(qWine.food.isNull())
                .limit(3)
                .fetch();
    }

/*
    @Override
    public List<Wine> findAllWine() {
        // 기본 와인 리스트를 반환하는 로직
        QWine qWine = QWine.wine;

        List<Wine> defaultWines = query.selectFrom(qWine)
                .where(qWine.food.contains())
                .limit(3)
                .fetch();
        log.info("defaultWines={}", defaultWines);

        return defaultWines;
    }
*/

}