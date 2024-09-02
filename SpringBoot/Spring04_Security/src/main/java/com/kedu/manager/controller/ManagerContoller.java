package com.kedu.manager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerContoller {

    @GetMapping
    public ResponseEntity<Void> index() {
        System.out.println("관리자 기능임~");
        return ResponseEntity.ok().build();
    }
}
