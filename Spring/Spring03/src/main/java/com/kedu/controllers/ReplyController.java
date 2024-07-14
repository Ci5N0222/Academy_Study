package com.kedu.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kedu.services.ReplyService;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	@Autowired
	private HttpSession session;

	@Autowired
	private ReplyService replyService;
	
	@ResponseBody	
	@RequestMapping("/insert")
	public Map<String, Object> replyInsert(int seq, String content) {
		String id = (String)session.getAttribute("loginID");
		return replyService.replyInsert(id, seq, content);
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public Map<String, Object> replyList(int boardSeq) {
		String id = (String)session.getAttribute("loginID");
		return replyService.replyList(id, boardSeq);
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public Map<String, Object> replyDelete(int seq) {
		return replyService.replyDelete(seq);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Map<String, Object> replyUpdate(int seq, String content) {
		return replyService.replyUpdate(seq, content);
	}

}
