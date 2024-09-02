package com.kedu.config;

import com.kedu.config.filters.JWTAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JWTAuthenticationFilter jwtFilter;

    /** 보완 관련 코드 작성 **/
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            /** Cors **/
            .cors(cors -> cors.configurationSource(request -> {
               CorsConfiguration corsConfig = new CorsConfiguration();
               corsConfig.setAllowedOrigins(Arrays.asList("http://192.168.1.7:3000"));
               corsConfig.setAllowedHeaders(Arrays.asList("*"));
               corsConfig.setAllowedMethods(Arrays.asList("*"));
               return corsConfig;
            }))

            /** CSRF **/
            // CSRF 공격 방지 기능 ( 보안 설정으로 실습 중에는 꺼둘 것 )
            .csrf(csrf -> csrf.disable())

            /** Login Form **/
            // Spring에서 기본 제공하는 login 폼 disable
            .formLogin(form -> form.disable())

            /** Http Basic **/
            // RESTFul 웹 개발에선 풀필요한 옵션
            .httpBasic(basic -> basic.disable())

            /** authentic **/
            // 페이지의 인증과 인과를 관리
            .authorizeHttpRequests(req ->
                req
                .requestMatchers(HttpMethod.POST, "/auth").permitAll()   // excludePatternPath
                .requestMatchers("/admin/**").hasRole("ADMIN")       // excludePatternPath
                .anyRequest().authenticated())    // 모든 리퀘스트는 인증되어 있어야만 하며, 제일 뒤에 붙어야 한다.
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        /**
         * Spring Security의 인증
         *  - Spring Security는 자체 인증 과정이 있다.
         *  1. SecurityContextHolder 안에 Authentication 이라는 인증 객체가 저장 되었는지 유무로 인증을 판단한다.
         */

        return http.build();
    }

    @Bean
    protected PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
