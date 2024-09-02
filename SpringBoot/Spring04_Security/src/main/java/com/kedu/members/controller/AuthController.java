package com.kedu.members.controller;

import com.kedu.commons.util.JwtUtil;
import com.kedu.members.dto.MembersDTO;
import com.kedu.members.service.MembersService;
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
    private MembersService membersService;

    @Autowired
    private JwtUtil jwt;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody MembersDTO dto) {
        String token = jwt.createToken(dto.getId());
        return ResponseEntity.ok(token);

    }

}
