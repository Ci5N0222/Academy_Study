package com.kedu.springboot_01.config;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

public class HttpSessionInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
            Map<String, Object> attributes) throws Exception {
        // endpoint로 보내는 map. userproperties가 매개변수로 나와있다.
        ServletServerHttpRequest sReq = (ServletServerHttpRequest)request;
        HttpSession session = sReq.getServletRequest().getSession();
        System.out.println("HttpSessionInterceptor === " + (String) session.getAttribute("loginID"));
        attributes.put("hSession", session);

        return true;
    }

    // 추상메소드라 오버라이딩 해놨지만 굳이 건들 필요 없긴 함
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
            Exception exception) {
        // TODO Auto-generated method stub

    }

}
