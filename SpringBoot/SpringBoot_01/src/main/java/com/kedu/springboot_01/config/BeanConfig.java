package com.kedu.springboot_01.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Gson getGson() {
        return new Gson();
    }
}
