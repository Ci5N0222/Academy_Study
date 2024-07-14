package com.kedu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.ReplyDTO;

@Repository
public class ReplyDAO {
	
	@Autowired
	private SqlSession mybatis;
	
	/** 댓글 작성 **/
	public int replyInsert(ReplyDTO dto) throws Exception {
		return mybatis.insert("Reply.replyInsert", dto);
	}
	
	/** 댓글 목록의 수 **/
	public int replyCount(int board_seq) throws Exception {
		return mybatis.selectOne("Reply.replyCount", board_seq);
	}
	
	/** 댓글 목록 **/
	public List<ReplyDTO> replyList(int board_seq) throws Exception {
		return mybatis.selectList("Reply.replyList", board_seq);
	}

	/** 게시글 수정 **/
	public int replyUpdate(ReplyDTO dto) throws Exception {
		return mybatis.update("Reply.replyUpdate", dto);
	}
	
	/** 게시글 삭제 **/
	public int replyDelete(int seq) throws Exception {
		return mybatis.delete("Reply.replyDelete", seq);
	}
	
}
