package com.kedu.springboot_01.handlers;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ChatHandler extends TextWebSocketHandler {

    @Autowired
    private Gson gson;

    // HttpSession을 제외한 다른 Bean들은 @Autowired 사용 가능

    // 컴포넌트 스캔을 돌려도 된다.
    // bean 만들 때 항상 컴포넌트 스캔을 돌려서 해결해왔다 하지만 다른 방법은 쓰겠다. 나중에 고쳐야 할 수 도?

    // 컴포넌트 스캔을 돌려도 된다.
    // bean 만들 때 항상 컴포넌트 스캔을 돌려서 해결해왔다 하지만 다른 방법은 쓰겠다. 나중에 고쳐야 할 수 도?
    // endpoint를 사용할 때는 사용자마다 생성되지않나요 하지만 지금은 @bean 태그를 만들어서 default값이 singleton이다.
    private Set<WebSocketSession> clients = Collections.synchronizedSet(new HashSet<>());

//   @Autowired
//   private session
    // HandShaking 과정에 끼어 들어서 가져오기
    // 그냥 핸드쉐이킹 과정에서 끼어들어서 가져오는 걸 interceptors라고 표현한 것


    // @OnOpen
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("웹소켓 연결");
        clients.add(session);
    }

    // @OnMessage
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String msg = message.getPayload();
        System.out.println(msg);
        HttpSession hSession = (HttpSession) session.getAttributes().get("hSession");
        System.out.println(hSession.getAttribute("loginID"));

        // 동시성 오류 안만들려고
        synchronized(clients){
            for(WebSocketSession client : clients) {
                try {
                    client.sendMessage(message);
                } catch(Exception e) {
                    // 에러 날 경우의 수는 연결 끊어짐뿐
                }
            }
        }

//      session.sendMessage(message);
    }

    // @OnClose
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        clients.remove(session);
    }


}
