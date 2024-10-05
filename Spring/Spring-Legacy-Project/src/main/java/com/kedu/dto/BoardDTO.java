package com.kedu.dto;

import java.sql.Timestamp;

public class BoardDTO {

	private int board_seq;
	private String board_writer;
	private String board_title;
	private String board_content;
	private Timestamp write_date;
	private int board_count;
	
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	public int getBoard_count() {
		return board_count;
	}
	public void setBoard_count(int board_count) {
		this.board_count = board_count;
	}
	
	public BoardDTO(int board_seq, String board_writer, String board_title, String board_content, Timestamp write_date,
			int board_count) {
		super();
		this.board_seq = board_seq;
		this.board_writer = board_writer;
		this.board_title = board_title;
		this.board_content = board_content;
		this.write_date = write_date;
		this.board_count = board_count;
	}
	
	public BoardDTO() {
		
	}
	
}
