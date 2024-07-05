package com.kedu.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.BoardDAO;
import com.kedu.dto.BoardDTO;

import commons.page.PageConfig;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private BoardDAO boardDAO;
	
	@RequestMapping("/list")
	public String boardList(Model model, Integer cpage) throws Exception {
		if(cpage == null) cpage = 1;
		int start = cpage * PageConfig.BOARD_RECORD_PAGE - (PageConfig.BOARD_RECORD_PAGE - 1);
		int end = cpage * PageConfig.BOARD_RECORD_PAGE;
		
		List<BoardDTO> list = boardDAO.boardList(start, end);
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@RequestMapping("/insert")
	public String insert() throws Exception {
		return "board/insert";
	}
	
	@RequestMapping("/insertProc")
	public String insertProc(BoardDTO dto) throws Exception {
		dto.setWriter((String)session.getAttribute("loginID"));
		boardDAO.boardInsert(dto);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model, int seq) throws Exception {
		BoardDTO dto = boardDAO.baordDetail(seq);
		model.addAttribute("dto", dto);
		return "board/detail";
	}
	
	@RequestMapping("/update")
	public String update(BoardDTO dto) throws Exception{
		dto.setWriter((String) session.getAttribute("loginID"));
		boardDAO.boardUpdate(dto);
		return "redirect:/board/detail?seq=" + dto.getSeq();
	}
	
	@RequestMapping("/delete")
	public String delete(int seq) throws Exception {
		boardDAO.boardDelete(seq);
		return "redirect:/board/list";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "error";
	}
}
