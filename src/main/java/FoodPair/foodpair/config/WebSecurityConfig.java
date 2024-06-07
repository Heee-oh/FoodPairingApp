package FoodPair.foodpair.config;

import FoodPair.foodpair.Filter.JwtAuthFilter;
import FoodPair.foodpair.Security.MyAuthenticationEntryPoint;
import FoodPair.foodpair.domain.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.naming.AuthenticationException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                // 세션 사용 안함
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exception -> exception
                        // 인증 실패 처리
                        .authenticationEntryPoint(new MyAuthenticationEntryPoint())

                )
                .authorizeHttpRequests(auth -> auth
                        // 회원가입, 로그인 관련 API는 Jwt 인증 없이 접근 가능
                        // antMatchers() 최신버전 기준 삭제됨
                        .requestMatchers("/api/Auth/**"
                                ,"http://localhost8080/Auth"
                                ,"/Auth"
                        ,"/**").permitAll()
                        // 나머지 모든 API는 Jwt 인증 필요
                        .anyRequest().authenticated()
                )
                // Http 요청에 대한 Jwt 유효성 선 검사
                .addFilterBefore(new JwtAuthFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
                .cors(corsCustomizer -> corsCustomizer.configurationSource(corsConfigurationSource()));

        return http.build();
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOriginPattern("*"); // 모든 도메인 허용하는 패턴 사용
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // 허용하는 HTTP 메소드
        config.setAllowCredentials(true); // 쿠키/자격증명 허용
        config.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type")); // 허용하는 헤더
        config.setMaxAge(3600L); // 사전 요청(pre-flight) 캐싱 시간


        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // 설정 적용 경로
        return source;
    }


}