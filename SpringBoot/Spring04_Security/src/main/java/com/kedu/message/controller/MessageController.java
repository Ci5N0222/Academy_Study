package com.kedu.message.controller;

import com.kedu.commons.util.JwtUtil;
import com.kedu.message.dto.MessageDTO;
import com.kedu.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private JwtUtil jwt;

    @GetMapping
    public ResponseEntity<List<MessageDTO>> getMessages(@AuthenticationPrincipal UserDetails user) {
        System.out.println("user ==== " + user.getUsername());
        List<MessageDTO> list = messageService.getMessages();
        return ResponseEntity.ok(list);
    }


    @DeleteMapping("/{seq}")
    public ResponseEntity<String> delMessage(@RequestAttribute String loginID, @PathVariable int seq) {
        System.out.println("seq ==== " + seq);
        System.out.println(loginID+"님의 요청");
        String result = messageService.delMessage(seq);
        return ResponseEntity.ok(result);
    }

}