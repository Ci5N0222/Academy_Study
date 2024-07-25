package com.kedu.springboot_01.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/socket")
public class SocketContoller {

    @Autowired
    private HttpSession session;

    @PostMapping
    public ResponseEntity<String> testLogin() {
        session.setAttribute("loginID", "QWER");
        System.out.println("session get id from controller " +  session.getAttribute("loginID"));
        return ResponseEntity.ok("로그인 성공");

    }

}
