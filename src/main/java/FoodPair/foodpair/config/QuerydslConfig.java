package FoodPair.foodpair.config;

import FoodPair.foodpair.respository.CommunityRepository;
import FoodPair.foodpair.respository.FoodPairRepository;
import FoodPair.foodpair.respository.QuerydslFoodPairRepository;
import FoodPair.foodpair.service.PostService;
import FoodPair.foodpair.service.PostServiceV1;
import FoodPair.foodpair.service.PostServiceV2;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class QuerydslConfig {

    private final EntityManager em;

    private final CommunityRepository communityRepository;

    @Bean
    public PostService postService() {
        return new PostServiceV2(communityRepository);
    }

    @Bean
    public FoodPairRepository foodPairRepository() {
        return new QuerydslFoodPairRepository(em);
    }

}
