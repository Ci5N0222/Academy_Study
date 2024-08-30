package com.kedu.config;

import com.kedu.interceptors.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private LoginValidator loginValidator;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginValidator)
                .addPathPatterns("/**")
                .excludePathPatterns("/auth");      // 로그인 화면은 인터셉트 제외
    }
}
