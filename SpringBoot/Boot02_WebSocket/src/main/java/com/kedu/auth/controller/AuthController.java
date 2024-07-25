package com.kedu.auth.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private HttpSession session;

    @PostMapping
    public ResponseEntity<Void> login() {

        session.setAttribute("loginID", "QWER");

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<String> test() {

        return ResponseEntity.ok("test");
    }

}
