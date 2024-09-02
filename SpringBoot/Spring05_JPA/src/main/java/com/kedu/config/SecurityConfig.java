package com.kedu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Cors
                .cors(cors -> cors.configurationSource(req -> {
                    CorsConfiguration corsConfig = new CorsConfiguration();
                    corsConfig.setAllowedOrigins(Arrays.asList("http://192.168.1.7:3000"));
                    corsConfig.setAllowedHeaders(Arrays.asList("*"));
                    corsConfig.setAllowedMethods(Arrays.asList("*"));

                    return corsConfig;
                }))

                // CSRF
                .csrf(csrf -> csrf.disable())

                // Login form
                .formLogin(form -> form.disable())

                // Http Basic
                .httpBasic(basic -> basic.disable());

        return http.build();
    }

}
