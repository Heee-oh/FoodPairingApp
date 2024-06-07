package FoodPair.foodpair.config;

import FoodPair.foodpair.domain.JwtTokenProvider;
import FoodPair.foodpair.respository.*;
import FoodPair.foodpair.service.PostService;
import FoodPair.foodpair.service.PostServiceV2;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class QuerydslConfig {

    private final EntityManager em;

    private final CommunityRepository communityRepository;

    private final CommentRepository commentRepository;

    private final WineRepository wineRepository;

    private final JwtTokenProvider jwtTokenProvider;
    @Bean
    public PostService postService() {
        return new PostServiceV2(communityRepository, commentRepository, jwtTokenProvider);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public FoodPairRepository foodPairRepository() {
        return new QuerydslFoodPairRepository(em);
    }


}
