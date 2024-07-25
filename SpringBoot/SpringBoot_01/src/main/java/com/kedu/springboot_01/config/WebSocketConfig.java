package com.kedu.springboot_01.config;

import com.kedu.springboot_01.handlers.ChatHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    //   @Autowired
    //   ChatHandler
    // component 스캔 돌려서 autowired 해서 넣어도 되긴 하지만 다른 방법 써보겠다.

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.
                addHandler(getChatHandler(), "/chat").
                setAllowedOrigins("*")
                .addInterceptors(new HttpSessionInterceptor());

    }

    // Spring Legacy에서 <bean>과 동일
    // @bean이 없으면 우리가 직접 만들어서 넣는거지만 @bean을 붙였으므로 스프링이 만들어서 보내준다.
    @Bean
    public WebSocketHandler getChatHandler() {
        return new ChatHandler();
    }

}
