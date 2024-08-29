package com.kedu.employee.controller;

import com.kedu.employee.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // 로그인

    @PostMapping
    public ResponseEntity<String> login(@RequestBody EmployeeDTO dto) {
        return null;
    }
}
