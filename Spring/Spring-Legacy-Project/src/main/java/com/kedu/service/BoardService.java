package com.kedu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.dao.BoardDAO;
import com.kedu.dto.BoardDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	/** 게시물 목록 **/
	public List<BoardDTO> boardList(){
		try {
			return boardDAO.boardList();	
		} catch(Exception e) {
			return null;
		}
	}
	
	/** 총 게시물 수 **/
	public int totalCount() {
		try {
			return boardDAO.totalCount();	
		} catch(Exception e) {
			return 0;
		}
	}
	
	/** 게시물 상세 정보 **/
	public BoardDTO boardDetail(int seq) {
		try {
			return boardDAO.boardDetail(seq);
		} catch(Exception e) {
			return null;
		}
	}
	
	/** 게시물 추가 **/
	public String addBoard(BoardDTO dto) {
		try {
			int result = boardDAO.addBoard(dto);
			return result > 0 ? "ok" : "fail";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/** 게시물 삭제 **/
	public String delBoard(int seq) {
		try {
			int result = boardDAO.delBoard(seq);
			return result > 0 ? "ok" : "fail";
		} catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/** 게시물 수정 **/
	public String modBoard(BoardDTO dto) {
		try {
			int result = boardDAO.modBoard(dto);
			return result > 0 ? "ok" : "fail";
		} catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
}
