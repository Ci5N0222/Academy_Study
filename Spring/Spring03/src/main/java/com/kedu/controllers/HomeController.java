package com.kedu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kedu.dao.BoardDAO;

import commons.page.PageConfig;
import commons.page.PageDTO;

@Controller
public class HomeController {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private Gson gson;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="/pagenavi", produces="text/html;charset=utf8")
	public String pagenavi(String target, int cpage){
		String returnData = "{\"result\": \"fail\"}";
		
		try {
			int count = 0;
			int recordPage = PageConfig.BOARD_RECORD_PAGE;
			int naviPage = PageConfig.BOARD_NAVI_PAGE;
			String url = PageConfig.BOARD_PAGE;
			
			switch(target) {
				case "board" :
					count = boardDAO.boardCount();
					break;
			}
			
			PageDTO result = new PageDTO(cpage, count, recordPage, naviPage, url);
			returnData = "{\"result\": \"ok\", \"data\": "+ gson.toJson(result) +"}";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnData;
	}

	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "error";
	}
	
}
