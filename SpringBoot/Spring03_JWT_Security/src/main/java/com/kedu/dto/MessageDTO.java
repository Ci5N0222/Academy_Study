package com.kedu.dto;

public class MessageDTO {
    private String seq;
    private String title;
    private String message;

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageDTO() {}

    public MessageDTO(String seq, String title, String message) {
        this.seq = seq;
        this.title = title;
        this.message = message;
    }
}
