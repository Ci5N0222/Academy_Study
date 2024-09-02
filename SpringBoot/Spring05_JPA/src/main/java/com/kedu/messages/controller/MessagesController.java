package com.kedu.messages.controller;

import com.kedu.messages.dto.MessagesDTO;
import com.kedu.messages.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {

    @Autowired
    private MessagesService messagesService;


    @GetMapping
    public ResponseEntity<List<MessagesDTO>> getMessages() {
        List<MessagesDTO> list = messagesService.getAllMessages();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Void> saveMessages(@RequestBody MessagesDTO messagesDTO) {
        messagesService.saveMessages(messagesDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateMessages(@RequestBody MessagesDTO messagesDTO) {
        System.out.println("UpdateMessages seq ==== " + messagesDTO.getSeq());
        messagesService.updateMessages(messagesDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{seq}")
    public ResponseEntity<Void> deleteMessages(@PathVariable int seq) {
        System.out.println("deleteMessages seq ==== " + seq);
        messagesService.deleteMessages(seq);
        return ResponseEntity.ok().build();
    }

}
