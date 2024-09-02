package com.kedu.messages.domain.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MESSAGES_SEQ_GENERATOR")
    @SequenceGenerator(name="MESSAGES_SEQ_GENERATOR", sequenceName = "MESSAGES_SEQ", initialValue = 1, allocationSize = 1)
    private Long seq;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String message;

    @CreationTimestamp  // sysdate와 같은 기능
    @Column(name="write_date", nullable = false)
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

    public Messages() {}

    public Messages(Long seq, String writer, String message, Timestamp writeDate) {
        this.seq = seq;
        this.writer = writer;
        this.message = message;
        this.writeDate = writeDate;
    }
}
