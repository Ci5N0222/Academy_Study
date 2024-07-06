package com.kedu.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kedu.dao.ReplyDAO;
import com.kedu.dto.ReplyDTO;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private Gson gson;
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@ResponseBody	
	@RequestMapping("/insert")
	public String replyInsert(int seq, String content) {
		String returnData = "{\"result\": \"fail\"}";
		
		try {
			String id = (String)session.getAttribute("loginID");
			int result = replyDAO.replyInsert(seq, id, content);
			if(result > 0) returnData = "{\"result\": \"ok\"}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnData;
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public String replyList(int boardSeq) {
		String returnData = "{\"result\": \"fail\"}";

		try {
			String id = (String)session.getAttribute("loginID");
			List<ReplyDTO> result = replyDAO.replyList(boardSeq);
			returnData = "{\"result\": \"ok\", \"data\": "+ gson.toJson(result) +", \"user\" : "+ gson.toJson(id) +"}";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnData;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String replyDelete(int seq) {
		String returnData = "{\"result\": \"fail\"}";

		try {
			int result = replyDAO.replyDelete(seq);
			if(result > 0) returnData = "{\"result\": \"ok\"}";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnData;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String replyUpdate(int seq, String content) {
		String returnData = "{\"result\": \"fail\"}";

		try {
			int result = replyDAO.replyUpdate(seq, content);
			if(result > 0) returnData = "{\"result\": \"ok\"}";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnData;
	}

}
