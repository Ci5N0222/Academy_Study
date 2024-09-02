package com.kedu.messages.dto;

import java.sql.Timestamp;

public class MessagesDTO {

    private Long seq;
    private String writer;
    private String message;
    private Timestamp writeDate;

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
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

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Timestamp writeDate) {
        this.writeDate = writeDate;
    }

    public MessagesDTO() {}

    public MessagesDTO(Long seq, String writer, String message, Timestamp writeDate) {
        this.seq = seq;
        this.writer = writer;
        this.message = message;
        this.writeDate = writeDate;
    }
}
