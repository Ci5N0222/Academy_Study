package com.kedu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.BoardDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession mybatis;
	

	
	/** 게시글 목록의 수 **/
	public int boardCount() throws Exception {
		return mybatis.selectOne("Board.boardCount");
	}
	
	/** 게시글 목록 **/
	public List<BoardDTO> boardList(Map<String, Integer> map) throws Exception {
		return mybatis.selectList("Board.boardList", map);
	}
	
	/** 검색된 게시글 목록의 수 **/
	public int boardSearchCount(Map<String, Object> map) throws Exception {
		return mybatis.selectOne("Board.boardSearchCount", map);
	}
	
	/** 검색된 게시글 목록 **/
	public List<BoardDTO> boardSearchList(Map<String, Object> map) throws Exception {
		return mybatis.selectList("Board.boardSearchList", map);
	}
	
	/** 게시글 디테일 **/
	public BoardDTO boardDetail(int seq) throws Exception {
		return mybatis.selectOne("Board.boardDetail", seq);
	}
	
	/** 게시글 작성 **/
	public int boardInsert(BoardDTO dto) throws Exception {
		mybatis.insert("Board.boardInsert", dto);
		return dto.getSeq();
	}
	
	/** 게시글 수정 **/
	public int boardUpdate(BoardDTO dto) throws Exception {
		return mybatis.update("Board.boardUpdate", dto);
	}
	
	/** 게시글 삭제 **/
	public int boardDelete(int seq) throws Exception {
		return mybatis.delete("Board.boarDelete", seq);
	}
	
}
