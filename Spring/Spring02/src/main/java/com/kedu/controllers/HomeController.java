package com.kedu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.MessagesDAO;
import com.kedu.dto.MessagesDTO;

@Controller
public class HomeController {
	
	@Autowired
	private MessagesDAO messagesDAO;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/input")
	public String input() {
		return "input";
	}
	
	@RequestMapping("/inputProc")
	public String inputProc(MessagesDTO messagesDTO)throws Exception {
		messagesDAO.insert(messagesDTO);
		
		return "redirect:/";
	}
	
	@RequestMapping("/output")
	public String output(Model model) throws Exception {
		List<MessagesDTO> list = messagesDAO.selectAll();
		model.addAttribute("list", list);
		
		return "output";
	}
	
	@RequestMapping("/delete")
	public String delete(int seq) throws Exception {
		messagesDAO.delete(seq);
		
		return "redirect:/output";
	}
	
	@RequestMapping("/update")
	public String update(MessagesDTO dto) throws Exception {
		messagesDAO.update(dto);
		
		return "redirect:/output";
	}
	
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "error";
	}
}
