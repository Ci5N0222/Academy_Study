package com.kedu.springboot_01.controller;

import com.kedu.springboot_01.dto.MemberDTO;
import com.kedu.springboot_01.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private HttpSession session;

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> mypage() {
        String id = (String)session.getAttribute("sessionId");
        MemberDTO info = memberService.mypage(id);
        return ResponseEntity.ok(info);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody MemberDTO dto) {
        memberService.insert(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> memberDelete (@PathVariable(required = false) String id) {
        String sessionId = (String)session.getAttribute("sessionId");
        if(id.equals(sessionId)){
            memberService.delete(id);
            session.invalidate();
            return ResponseEntity.ok("삭제 완료");
        }
        return ResponseEntity.ok("삭제 실패");

        
    }
}
