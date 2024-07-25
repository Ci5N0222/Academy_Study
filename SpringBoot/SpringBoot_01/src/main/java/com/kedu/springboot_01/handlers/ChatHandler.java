package com.kedu.handlers;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatHandler extends TextWebSocketHandler {
    // 컴포넌트 스캔을 돌려도 된다.
    // bean 만들 때 항상 컴포넌트 스캔을 돌려서 해결해왔다 하지만 다른 방법은 쓰겠다. 나중에 고쳐야 할 수 도?

    // @OnOpen
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("웹소켓 연결");
    }

    // @OnMessage
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

    }

    // @OnClose
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

    }

}
