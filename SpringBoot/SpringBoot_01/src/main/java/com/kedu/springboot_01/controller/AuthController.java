package com.kedu.springboot_01.controller;

import com.kedu.springboot_01.dto.MemberDTO;
import com.kedu.springboot_01.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private HttpSession session;

    @PostMapping
    public ResponseEntity<String> auth(@RequestBody MemberDTO dto) {
        MemberDTO info = memberService.auth(dto);
        if(info == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Faild");
        }
        session.setAttribute("sessionId", dto.getId());
        return ResponseEntity.ok(info.getId());
    }

    @DeleteMapping
    public ResponseEntity<Void> auth() {
        session.invalidate();
        return ResponseEntity.ok().build();
    }

}
