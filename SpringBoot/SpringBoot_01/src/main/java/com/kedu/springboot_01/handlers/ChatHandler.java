package com.kedu.springboot_01.handlers;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.*;

@Component
public class ChatHandler extends TextWebSocketHandler {

    // legacy에서는 autowired를 쓸 수가 없었따.
    // Handler 하나를 수많은 사람들이 쓰게 되었기 때문에 autowired가 가능하다.
    // HTTPSEssion은 Autowired를 쓸 수 없다. 더 복잡한 메커니즘이 있기 때문에.
    // HTTPSession을 제외한 다른 Bean 들은 @Autowired 사용 가능
    // jackson은 objectMapper를 사용해야한다 사용해보는 것도 좋을듯?
    // Gson빈은 라이브러리기 때문에 Component 스캔이 안되니 configuration안에 bean 어노테이션을 사용한다.


    // 컴포넌트 스캔을 돌려도 된다.
    // bean 만들 때 항상 컴포넌트 스캔을 돌려서 해결해왔다 하지만 다른 방법은 쓰겠다. 나중에 고쳐야 할 수 도?
    // endpoint를 사용할 때는 사용자마다 생성되지않나요 하지만 지금은 @bean 태그를 만들어서 default값이 singleton이다.
    private Set<WebSocketSession> clients = Collections.synchronizedSet(new HashSet<>());

//   @Autowired
//   private session
    // HandShaking 과정에 끼어 들어서 가져오기
    // 그냥 핸드쉐이킹 과정에서 끼어들어서 가져오는 걸 interceptors라고 표현한 것

    @Autowired
    private Gson gson;

//   @Autowired
//   private MessageService service;

    // @OnOpen
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("웹소켓 연결");
        clients.add(session);
    }

    // @OnMessage
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        HttpSession hSession = (HttpSession) session.getAttributes().get("hSession");
        String id = (String) hSession.getAttribute("loginID");
        String msg = message.getPayload();
        System.out.println("hSession ID ==== " + id);
        // 로그인 아이디는 항상 세션에서 아이디를 꺼내서 볼 수 있게끔. 클라이언트가 보내는 건 절대 안됨. 변조됨

        //DTO로 해도 됨
        // id랑 msg를 json으로
        Map<String, String> data = new HashMap<>();
        data.put("id", id);
        data.put("message", msg);

        String result = gson.toJson(data);

        // 해쉬맵에 담아도 직렬화해서 담아야한다. 잭슨이 좀 복잡함 bean 태그 연습할 겸 gson 추가하겠음.
        // 자동화 형변화는 잭슨으로 하고 gson 으로 수동해봄.

        // 동시성 오류 안만들려고
        synchronized(clients){
            for(WebSocketSession client : clients) {
                try {
                    client.sendMessage(new TextMessage(result));
                } catch(Exception e) {
                    // 에러 날 경우의 수는 연결 끊어짐뿐
                }
            }
        }



//      session.sendMessage(message);
//      System.out.println(msg);
    }

    // @OnClose
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        clients.remove(session);
    }



}
