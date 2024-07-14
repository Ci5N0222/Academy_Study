package com.kedu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.kedu.dao.ChatDAO;
import com.kedu.dto.ChatDTO;

@Service
public class ChatService {

	@Autowired
	private Gson gson;
	
	@Autowired
	private ChatDAO chatDAO;
	
	/** 메세지 저장 **/
	public int saveMessage(ChatDTO dto) throws Exception {
		return chatDAO.saveMessage(dto);
	}
	
	/** 메세지 목록 **/
	public List<ChatDTO> selectAll() throws Exception {
		return chatDAO.selectAll();
	}
	
}
