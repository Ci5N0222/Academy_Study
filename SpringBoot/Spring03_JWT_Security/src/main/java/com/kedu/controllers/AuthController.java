package com.kedu.controllers;

import com.kedu.dto.MembersDTO;
import com.kedu.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JWTUtil jwt;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody MembersDTO dto) {
        String token = jwt.createToken(dto.getId());
        return ResponseEntity.ok(token);
    }

}
