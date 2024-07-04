package com.kedu.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.BoardDAO;
import com.kedu.dto.BoardDTO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BasicDataSource bds;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private BoardDAO boardDAO;
	
	@RequestMapping("/list")
	public String boardList(Model model) throws Exception {
		List<BoardDTO> list = boardDAO.getList();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@RequestMapping("/insert")
	public String insert() throws Exception {
		return "board/insert";
	}
	
	@RequestMapping("/insertProc")
	public String insertProc(String title, String content) throws Exception {
		boardDAO.insert((String)session.getAttribute("loginID"), title, content);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/detail")
	public String detail() throws Exception {
		return "board/detail";
	}
	
}
