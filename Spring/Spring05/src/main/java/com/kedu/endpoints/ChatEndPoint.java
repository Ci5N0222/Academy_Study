package com.kedu.endpoints;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatEndPoint {
	
	// 접속한 클라이언트의 정보를 보관
	private static Set<Session> clients =  Collections.synchronizedSet(new HashSet<>());
	
	@OnOpen
	public void onConnect(Session session) {
		System.out.println("연결 확인 : " + session.getId());
		clients.add(session);
	}
	
	@OnClose
	public void onClose(Session session) {
		clients.remove(session);
	}
	
	@OnError
	public void onError(Throwable t, Session session) {
		clients.remove(session);
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		// 동시성 오류를 피할 수 있는 기법
		synchronized (clients) {
			for(Session client : clients) {
				try {
					client.getBasicRemote().sendText(" 익명의 박새미 : " + message);
				} catch (Exception e) {}
			}
		}
	}
	
	
}
