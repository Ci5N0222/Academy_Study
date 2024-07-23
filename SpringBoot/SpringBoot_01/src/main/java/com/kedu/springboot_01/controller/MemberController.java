package com.kedu.springboot_01.controller;

import com.kedu.springboot_01.dto.MemberDTO;
import com.kedu.springboot_01.dto.MusicDTO;
import com.kedu.springboot_01.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody MemberDTO dto) {
        memberService.insert(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/signin")
    public ResponseEntity<Boolean> signIn(@RequestBody MemberDTO dto) {
        Boolean result = memberService.signIn(dto);
        return ResponseEntity.ok(result);
    }
}
