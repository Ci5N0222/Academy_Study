package com.kedu.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kedu.dto.BoardDTO;
import com.kedu.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardServ;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping
	public String boardList(Model model) {
		List<BoardDTO> list = boardServ.boardList();
		int count = boardServ.totalCount();
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		return "board/list";
	}
	
	@GetMapping("/detail")
	public String boardDetail(@RequestParam(name = "seq") int seq, Model model) {
		BoardDTO dto = boardServ.boardDetail(seq);
		model.addAttribute("dto", dto);
		return "board/detail";
	}
	
	@GetMapping("/write")
	public String boardWrite() {
		return "board/write";
	}
	
	@PostMapping
	public String addBoard(BoardDTO dto) {
		session.setAttribute("loginID", "tester");
		String id = (String) session.getAttribute("loginID");
		dto.setBoard_writer(id);
		boardServ.addBoard(dto);
		return "redirect: /board";
	}
	
	@PostMapping("/delete")
	public String delBoard(@RequestParam(name = "seq") int seq) {
		boardServ.delBoard(seq);
		return "redirect: /board";
	}
	
	@PostMapping("/update")
	public String modBoard(BoardDTO dto) {
		boardServ.modBoard(dto);
		return "board/detail?seq=" + dto.getBoard_seq();
	}
	
	
}
