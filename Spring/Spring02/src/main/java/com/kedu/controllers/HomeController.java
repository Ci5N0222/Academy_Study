package com.kedu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.MessagesDAO;
import com.kedu.dto.MessagesDTO;

@Controller
public class HomeController {
	
	@Autowired
	private MessagesDAO messagesDAO;
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home 요청 확인");
		return "home";
		// ViewResolver를 통해 경로가 완성됨 /WEB-INF/views/home.jsp
		// return은 기본적으로 forward
		// return "redirect:home";
		// redirect 일 경우 Dispatcher에서 ViewResolver에게 보내지 않고 바로 클라이언트에게 응답함
	}
	
	@RequestMapping("/input")
	public String input() {
		System.out.println("Input 진입");
		return "input";
	}
	
	@RequestMapping("/inputProc")
	public String inputProc(MessagesDTO messagesDTO) {
		
		try {
			messagesDAO.insert(messagesDTO);
			return "home";
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return "error";
	}
	
}
