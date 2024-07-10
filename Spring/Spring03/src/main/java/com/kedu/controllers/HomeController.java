package com.kedu.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kedu.services.HomeService;

@Controller
public class HomeController {
	
	@Autowired
	private HomeService homeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="/pagenavi", produces="text/html;charset=utf8")
	public Map<String, Object> pagenavi(String target, Map<String, Object> data){
		return homeService.navigator(target, data);
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "error";
	}
	
}
