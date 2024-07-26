package com.kedu.springboot_01.dto;

import java.sql.Timestamp;

public class PublishDTO {
    private Timestamp publish;

    public Timestamp getPublish() {
        return publish;
    }

    public void setPublish(Timestamp publish) {
        this.publish = publish;
    }

    public PublishDTO(Timestamp publish) {
        this.publish = publish;
    }
    public PublishDTO() {}
}
