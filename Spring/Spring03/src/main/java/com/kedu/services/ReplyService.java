package com.kedu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.kedu.dao.ReplyDAO;
import com.kedu.dto.ReplyDTO;

@Service
public class ReplyService {

	@Autowired
	private Gson gson;
	
	@Autowired
	private ReplyDAO replyDAO;
	
	/** 댓글 작성 **/
	public String replyInsert(String id, int seq, String content){
		String str = "{\"result\": \"fail\"}";
		try {
			int result = replyDAO.replyInsert(new ReplyDTO(0, id, content, seq, null));
			if(result > 0) str = "{\"result\": \"ok\"}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return str;
	}
	
	/** 댓글 목록 **/
	public String replyList(String id, int boardSeq) {
		String str = "{\"result\": \"fail\"}";
		try {
			List<ReplyDTO> result = replyDAO.replyList(boardSeq);
			str = "{\"result\": \"ok\", \"data\": "+ gson.toJson(result) +", \"user\" : "+ gson.toJson(id) +"}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return str;
	}
	
	/** 댓글 삭제 **/
	public String replyDelete(int seq) {
		String str = "{\"result\": \"fail\"}";
		try {
			int result = replyDAO.replyDelete(seq);
			if(result > 0) str = "{\"result\": \"ok\"}";

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return str;
	}
	
	/** 댓글 수정 **/
	public String replyUpdate(int seq, String content) {
		String str = "{\"result\": \"fail\"}";
		try {
			int result = replyDAO.replyUpdate(new ReplyDTO(seq, null, content, 0, null));
			if(result > 0) str = "{\"result\": \"ok\"}";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
}
