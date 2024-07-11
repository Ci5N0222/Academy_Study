package com.kedu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.ChatDTO;

@Repository
public class ChatDAO {

	@Autowired
	private SqlSession mybatis;
	
	/** 메세지 저장 **/
	public int saveMessage(ChatDTO dto) throws Exception {
		return mybatis.insert("Chat.insert", dto); 
	}
	
	/** 메세지 목록 **/
	public List<ChatDTO> selectAll() throws Exception {
		return mybatis.selectList("Chat.selectAll");
	}
}
