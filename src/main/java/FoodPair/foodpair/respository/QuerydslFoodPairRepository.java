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
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Post save(Post post) {
        em.persist(post);
        return post;
    }

    @Override
    public Optional<Post> findById(int id) {
        updateViews(id); // 조회수 증가
        Post post = em.find(Post.class, id);
        return Optional.ofNullable(post);
    }

    @Override
    public List<Post> findAllPost() {
        return query.select(post)
                .from(post)
                .fetch();
    }

    @Override
    public void deletePost(int id) {
        query.delete(post)
                .where(post.id.eq(id))
                .execute();
    }

    @Override
    public Post update(int postId, UpdatePostDto updatePostDto) {
        return null;
    }

/*
    @Override
    public Post update(int postId, UpdatePostDto updatePostDto) {
        return null;
    }
*/

    @Override
    public void updateViews(int id) {

    }

    public void updateViews(Long id) {
        em.createQuery("update community set viewCount = viewCount + 1 where id = " + id)
                .executeUpdate();
    }


}
