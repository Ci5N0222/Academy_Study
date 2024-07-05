package com.kedu.dao;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.BoardDTO;

@Repository
public class BoardDAO {

	@Autowired
	private JdbcTemplate jdbc;
	
	/** 게시글 작성 **/
	public int boardInsert(BoardDTO dto) throws Exception {
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate)";
		return jdbc.update(sql, dto.getWriter(), dto.getTitle(), dto.getContent());
	}
	
	/** 게시글 목록의 수 **/
	public int boardCount() throws Exception {
		String sql = "select count(*) from board";
		return jdbc.queryForObject(sql, Integer.class);
	}
	
	/** 게시글 목록 **/
	public List<BoardDTO> boardList(int start, int end) throws Exception {
		String sql = "select * from (select board.*, row_number() over(order by seq desc) rown from board) where rown between ? and ?";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(BoardDTO.class), start, end);
	}
	
	/** 게시글 디테일 **/
	public BoardDTO baordDetail(int seq) throws Exception {
		String sql = "select * from board where seq = ?";
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(BoardDTO.class), seq);
	}
	
	/** 게시글 수정 **/
	public int boardUpdate(BoardDTO dto) throws Exception {
		String sql = "update board set title = ?, content = ? where seq = ?";
		return jdbc.update(sql, dto.getTitle(), dto.getContent(), dto.getSeq());
	}
	
	/** 게시글 삭제 **/
	public int boardDelete(int seq) throws Exception {
		String sql = "delete from board where seq = ?";
		return jdbc.update(sql, seq);
	}
	
}
