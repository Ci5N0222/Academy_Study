package com.kedu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.BoardDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession mybatis;
	
	public List<BoardDTO> boardList(){
		return mybatis.selectList("Board.list");
	}
	
	public int totalCount() {
		return mybatis.selectOne("Board.totalCount");
	}
	
	public BoardDTO boardDetail(int seq) {
		return mybatis.selectOne("Board.detail", seq);
	}
	
	public int addBoard(BoardDTO dto) {
		return mybatis.insert("Board.write", dto);
	}
	
	public int delBoard(int seq) {
		return mybatis.delete("Board.delete", seq);
	}
	
	public int modBoard(BoardDTO dto) {
		return mybatis.update("Board.update", dto);
	}
}
