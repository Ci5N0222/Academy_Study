package com.kedu.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.MessagesDAO;
import com.kedu.dto.MessagesDTO;
import com.kedu.service.MessagesService;

@Controller
public class HomeController {
	
	@Autowired
	private MessagesDAO messagesDAO;
	
	@Autowired
	private MessagesService messagesService;
	
	@RequestMapping("/")
	public String home() {
		return "search";
	}
	
	@RequestMapping("/output")
	public String output(Model model) throws Exception {
		List<Map<String, Object>> list = messagesService.output();
		model.addAttribute("list", list);
		return "output";
	}
	
	@RequestMapping("/search")
	public String search(String column, String keyword) throws Exception {
		List<MessagesDTO> list =  messagesService.search(column, keyword);
		for(MessagesDTO dto : list) {
			System.out.println(dto.getSeq() +" : "+ dto.getWriter() +" : "+ dto.getMessage());
		}
		return "search";
	}
	
	@RequestMapping("/searchMulti")
	public String searchMulti(String writer, String message) throws Exception {
		List<MessagesDTO> list =  messagesService.searchMulti(writer, message);
		for(MessagesDTO dto : list) {
			System.out.println(dto.getSeq() +" : "+ dto.getWriter() +" : "+ dto.getMessage());
		}
		return "search";
	}
	
	@RequestMapping("/update")
	public String update(MessagesDTO dto) throws Exception {
		messagesDAO.update(dto);
		return "redirect:/output";
	}
	
	@RequestMapping("/input")
	public String input() {
		return "input";
	}
	
	@RequestMapping("/inputProc")
	public String inputProc(MessagesDTO messagesDTO) throws Exception {
		messagesDAO.insert(messagesDTO);
		return "redirect:/";
	}
	
	@RequestMapping("/delete")
	public String delete(int seq) throws Exception {
		messagesDAO.delete(seq);
		return "redirect:/output";
	}
	
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "error";
	}
}
