package com.kedu.dto;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class ReplyDTO {
	
	private int seq;
	private String writer;
	private String content;
	private int board_seq;
	private Timestamp write_date;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	
	public ReplyDTO(int seq, String writer, String content, int board_seq, Timestamp write_date) {
		this.seq = seq;
		this.writer = writer;
		this.content = content;
		this.board_seq = board_seq;
		this.write_date = write_date;
	}
	
	public ReplyDTO() {}
	
}
