package com.kedu.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kedu.dao.BoardDAO;
import com.kedu.dao.FilesDAO;
import com.kedu.dto.BoardDTO;
import com.kedu.services.BoardService;
import com.kedu.services.FilesService;

import commons.page.PageConfig;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping("/list")
	public String boardList(Model model, Integer cpage) throws Exception {
		List<BoardDTO> list = boardService.boardList(cpage);
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@RequestMapping("/searchList")
	public String boardSearchList(Model model, String select, String search, Integer cpage) throws Exception {
		List<BoardDTO> list = boardService.boardSearchList(select, search, cpage);
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@RequestMapping("/insert")
	public String insert() throws Exception {
		return "board/insert";
	}
	
	@RequestMapping("/insertProc")
	public String insertProc(BoardDTO dto, MultipartFile[] files) throws Exception {
		dto.setWriter((String)session.getAttribute("loginID"));
		String realPath = session.getServletContext().getRealPath("upload");
		int seq = boardService.boardAndFilesInsert(dto, files, realPath);
		
		return "redirect:/board/detail?seq=" + seq;
	}
	
	@RequestMapping("/detail")
	public String detail(Model model, int seq) throws Exception {
		BoardDTO dto = boardService.boardDetail(seq);
		model.addAttribute("dto", dto);
		return "board/detail";
	}
	
	@RequestMapping("/update")
	public String update(BoardDTO dto) throws Exception{
		dto.setWriter((String) session.getAttribute("loginID"));
		boardService.boardUpdate(dto);
		return "redirect:/board/detail?seq=" + dto.getSeq();
	}
	
	@RequestMapping("/delete")
	public String delete(int seq) throws Exception {
		boardService.boardDelete(seq);
		return "redirect:/board/list";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "error";
	}
}
