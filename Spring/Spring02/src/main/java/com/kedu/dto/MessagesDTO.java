package com.kedu.dto;

import org.springframework.stereotype.Component;

@Component
public class MessagesDTO {

	/** Field **/
	private int seq;
	private String writer;
	private String message;
	
	/** getter & setter **/
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String messgae) {
		this.message = messgae;
	}
	
	/** Constructor **/
	public MessagesDTO() {}
	
	public MessagesDTO(int seq, String writer, String message) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.message = message;
	}
	
}
