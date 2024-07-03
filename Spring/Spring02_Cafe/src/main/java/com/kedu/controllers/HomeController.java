package com.kedu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.CafeDAO;
import com.kedu.dto.CafeDTO;

@Controller
public class HomeController {

	@Autowired
	private CafeDAO cafeDAO;
	
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/input")
	public String input() {
		return "add_menu";
	}
	
	@RequestMapping("/inputProc")
	public String inputProc(CafeDTO dto) {
		
		try {
			cafeDAO.addMenu(dto);
			return "home";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}
	
}
