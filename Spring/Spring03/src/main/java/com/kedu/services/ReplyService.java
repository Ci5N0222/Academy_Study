package com.kedu.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.dao.ReplyDAO;
import com.kedu.dto.ReplyDTO;

@Service
public class ReplyService {

	@Autowired
	private ReplyDAO replyDAO;
	
	/** 댓글 작성 **/
	public Map<String, Object> replyInsert(String id, int seq, String content){
		Map<String, Object> map = new HashMap<>();
		map.put("result", "fail");
		try {
			int result = replyDAO.replyInsert(new ReplyDTO(0, id, content, seq, null));
			if(result > 0) map.put("result", "ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	/** 댓글 목록 **/
	public Map<String, Object> replyList(String id, int boardSeq) {
		Map<String, Object> map = new HashMap<>();
		map.put("result", "fail");
		try {
			List<ReplyDTO> result = replyDAO.replyList(boardSeq);
			map.put("result", "ok");
			map.put("data", result);
			map.put("user", id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	/** 댓글 삭제 **/
	public Map<String, Object> replyDelete(int seq) {
		Map<String, Object> map = new HashMap<>();
		map.put("result", "fail");
		try {
			int result = replyDAO.replyDelete(seq);
			if(result > 0) map.put("result", "ok");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	/** 댓글 수정 **/
	public Map<String, Object> replyUpdate(int seq, String content) {
		Map<String, Object> map = new HashMap<>();
		map.put("result", "fail");
		try {
			int result = replyDAO.replyUpdate(new ReplyDTO(seq, null, content, 0, null));
			if(result > 0) map.put("result", "ok");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
}
