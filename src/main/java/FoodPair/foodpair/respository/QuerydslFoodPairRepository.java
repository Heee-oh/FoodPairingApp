package FoodPair.foodpair.respository;

import FoodPair.foodpair.domain.*;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

        return allWine;
    }

    @Override
    public List<Wine> findDefaultWines() {
        QWine qWine = QWine.wine;
        List<Wine> fetch = query.selectFrom(qWine)
                .where(qWine.food.isNull())
                .limit(3)
                .fetch();
        log.info("winefff={}", fetch);
        return fetch;

    }


    public List<PostDto> findAllPostsWithWine() {
        QPost qPost = QPost.post;
        QWine qWine = QWine.wine;
        QUser qUser = QUser.user;

        List<Tuple> fetch = query.select(qPost, qWine,qUser)
                .from(qPost)
                .join(qWine).on(qWine.wineId.eq(qPost.wineId))
                .join(qUser).on(qUser.uuid.eq(qPost.uuid))
                .orderBy(qPost.id.desc())
                .fetch();

        List<PostDto> postDtos = new ArrayList<>();

        for (Tuple tuple : fetch) {
            Post post = tuple.get(qPost);
            Wine wine = tuple.get(qWine);
            User user = tuple.get(qUser);
            PostDto postDto = new PostDto(post, wine, user);
            postDtos.add(postDto);
        }

        return postDtos;
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