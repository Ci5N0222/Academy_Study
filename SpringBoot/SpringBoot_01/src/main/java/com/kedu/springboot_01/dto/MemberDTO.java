package com.kedu.springboot_01.dto;

import org.springframework.stereotype.Component;

@Component("MemberDTO")
public class MemberDTO {
    private String id;
    private String pw;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberDTO(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public MemberDTO() {}
}
