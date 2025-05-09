package com.kedu.controllers;

import com.kedu.dto.MessageDTO;
import com.kedu.services.MessageService;
import com.kedu.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private JWTUtil jwt;

    @GetMapping
    public ResponseEntity<List<MessageDTO>> getMessages(@AuthenticationPrincipal UserDetails user) {

        System.out.println("user ==== " + user.getUsername());

        // Spring Security : SecurityContextHolder에 저장된 Authentication에서 사용자의 정보를 가져온다.
        //String id = SecurityContextHolder.getContext().getAuthentication().getName();
        // System.out.println(id+"님의 요청");

        List<MessageDTO> list = messageService.getMessages();
        return ResponseEntity.ok(list);
    }

//    @GetMapping
//    public ResponseEntity<List<MessageDTO>> getMessages(@RequestAttribute String loginID) {
//        System.out.println(loginID+"님의 요청");
//        List<MessageDTO> list = messageService.getMessages();
//        return ResponseEntity.ok(list);
//    }

    @DeleteMapping("/{seq}")
    public ResponseEntity<String> delMessage(@RequestAttribute String loginID, @PathVariable int seq) {
        System.out.println("seq ==== " + seq);
        System.out.println(loginID+"님의 요청");
        String result = messageService.delMessage(seq);
        return ResponseEntity.ok(result);
    }

}