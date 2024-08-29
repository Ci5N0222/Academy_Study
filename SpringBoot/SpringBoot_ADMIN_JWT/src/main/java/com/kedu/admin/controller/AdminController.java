package com.kedu.admin.controller;

import com.kedu.employee.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> selectAll() {
        return null;
//        return ResponseEntity.ok("꺼내온 데이터 리스트");
    }
}
