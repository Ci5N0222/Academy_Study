package com.kedu.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kedu.services.FilesService;

@Controller
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private FilesService service;
	
	
	@RequestMapping("/upload")
	public String upload(String msg, MultipartFile[] file) throws Exception {
		
		String realPath = session.getServletContext().getRealPath("upload");

		service.uploadFile(realPath, file);
		
		return "redirect:/";
	}

}
