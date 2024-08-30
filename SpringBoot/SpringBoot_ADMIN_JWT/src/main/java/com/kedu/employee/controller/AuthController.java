package com.kedu.employee.controller;

import com.kedu.employee.dto.SignDTO;
import com.kedu.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private EmployeeService employeeService;

    // 로그인
    @PostMapping
    public ResponseEntity<String> login(@RequestBody SignDTO dto) {
        System.out.println("id === " + dto.getEmpId());
        System.out.println("pw === " + dto.getEmpPw());
//        SignDTO empInfo = employeeService.signIn(dto);

        return ResponseEntity.ok("");
    }
}
