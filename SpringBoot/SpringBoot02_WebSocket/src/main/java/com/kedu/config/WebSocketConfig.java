package com.kedu.config;

import com.kedu.handlers.ChatHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
                .addHandler(getChatHandler(), "/chat")
                .setAllowedOrigins("*");
    }

    @Bean // Spring Legacy에서 <bean> 와 동일
    public WebSocketHandler getChatHandler() {
        return new ChatHandler();
    }
}
