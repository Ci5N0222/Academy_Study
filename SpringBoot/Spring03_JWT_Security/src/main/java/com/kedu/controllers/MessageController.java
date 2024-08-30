package com.kedu.controllers;

import com.kedu.dto.MessageDTO;
import com.kedu.services.MessageService;
import com.kedu.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private JWTUtil jwt;

    @GetMapping
    public ResponseEntity<List<MessageDTO>> getMessages(@RequestAttribute String loginID) {
        System.out.println(loginID+"님의 요청");
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