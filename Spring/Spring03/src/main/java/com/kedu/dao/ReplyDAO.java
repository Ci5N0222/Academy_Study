package com.kedu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.ReplyDTO;

@Repository
public class ReplyDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	

	/** 댓글 작성 **/
	public int replyInsert(int boardSeq, String id, String content) throws Exception {
		String sql = "insert into reply values(reply_seq.nextval, ?, ?, ?, sysdate)";
		return jdbc.update(sql, id, content, boardSeq);
	}
	
	/** 댓글 목록의 수 **/
	public int replyCount(int board_seq) throws Exception {
		String sql = "select count(*) from reply where board_seq = ?";
		return jdbc.queryForObject(sql, Integer.class, board_seq);
	}
	
	/** 댓글 목록 **/
	public List<ReplyDTO> replyList(int boardSeq) throws Exception {
		String sql = "select * from (select reply.*, row_number() over(order by seq desc) rown from reply where board_seq = ?)";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(ReplyDTO.class), boardSeq);
	}

	/** 게시글 수정 **/
	public int replyUpdate(int seq, String content) throws Exception {
		String sql = "update reply set content = ? where seq = ?";
		return jdbc.update(sql, content, seq);
	}
	
	/** 게시글 삭제 **/
	public int replyDelete(int seq) throws Exception {
		String sql = "delete from reply where seq = ?";
		return jdbc.update(sql, seq);
	}
	
}
