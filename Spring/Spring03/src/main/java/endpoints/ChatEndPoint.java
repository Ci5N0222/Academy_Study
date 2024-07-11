package endpoints;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.JsonObject;
import com.kedu.configurators.SpringProvider;
import com.kedu.configurators.WSHttpSessionConfigurator;
import com.kedu.dto.ChatDTO;
import com.kedu.services.ChatService;

@ServerEndpoint(value = "/chat", configurator = WSHttpSessionConfigurator.class)
public class ChatEndPoint {
	
	// 접속한 클라이언트의 정보를 보관
	private static Set<Session> clients =  Collections.synchronizedSet(new HashSet<>());
	
	private static Set<String> group = Collections.synchronizedSet(new HashSet<>());
	
	private HttpSession hSession;
	
	private ChatService chatService = SpringProvider.getSpring().getBean(ChatService.class);
	
	@OnOpen
	public void onConnect(EndpointConfig config, Session session) {
		this.hSession = (HttpSession) config.getUserProperties().get("hSession");
		clients.add(session);
		
		String sender = (String) hSession.getAttribute("loginName");
		group.add(sender);
		
		onMessage(session, sender+" : 나 강림. 멋있음 확정.");
	}
	
	@OnClose
	public void onClose(Session session) {
		clients.remove(session);
		String sender = (String) hSession.getAttribute("loginName");
		onMessage(session, sender+" : 아디오스...");
	}
	
	@OnError
	public void onError(Throwable t, Session session) {
		clients.remove(session);
		String sender = (String) hSession.getAttribute("loginName");
		onMessage(session, sender+" : 아디오스...");
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		String sender = (String) hSession.getAttribute("loginName");
		
		try {
			int result = chatService.saveMessage(new ChatDTO(0, sender, message, null));
			
			if(result > 0) {
				JsonObject obj = new JsonObject();
				obj.addProperty("sender", sender);
				obj.addProperty("message", message);
				
				// 동시성 오류를 피할 수 있는 기법
				synchronized (clients) {
					for(Session client : clients) {
						try {
							client.getBasicRemote().sendText(obj.toString());
						} catch (Exception e) {}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
