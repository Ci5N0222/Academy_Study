package com.kedu.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kedu.dto.ChatDTO;
import com.kedu.services.ChatService;

@Controller
@RequestMapping("/chat")
public class ChatController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private ChatService chatService;
	
	@RequestMapping("/form")
	public String chat() {
		if((String)session.getAttribute("loginID") == null || (String)session.getAttribute("loginName") == "") {
			return "redirect:/";
		} else {
			return "chat/chat";
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public Map<String, Object> chatList() {
		Map<String, Object> map = new HashMap<>();
		try {
			List<ChatDTO> list = chatService.selectAll();
			map.put("result", "ok");
			map.put("data", list);
			map.put("user", (String)session.getAttribute("loginName"));
			
		} catch (Exception e) {
			map.put("result", "fail");
			e.printStackTrace();
		}
		
		return map;
	}
	
}
