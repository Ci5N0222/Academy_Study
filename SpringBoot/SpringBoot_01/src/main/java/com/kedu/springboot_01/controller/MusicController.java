package com.kedu.springboot_01.controller;

import com.kedu.springboot_01.dto.MusicDTO;
import com.kedu.springboot_01.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// http:localhost/post?id=abc&title=abc...
// http:localhost/post

// {id: "", ... } <-- ResponseBody

@RestController
public class MusicController {

    @Autowired
    private MusicService musicService;

    @PostMapping("/music")
    public ResponseEntity<Void> post(@RequestBody MusicDTO dto) {
        musicService.post(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/info")
    public String info() {
        return "info";
    }

    // @RequestBody : 클라이언트가 서버에게 전송하려는 직렬화 된 데이터를 자동 역직렬화 하는 어노테이션
    // @ResponseBody : 서버가 클라이언트에게 전송하는 Data를 자동 직력화 하는 어노테이션

    // CORS : Cross Origin Resource Sharing ( 보안 관련 이슈 )


    // Server Response Code number
    // 100~ :
    // 200~ : Success Code Number
    // 300~ : Redirect Code Number
    // 400~ : Client Error Code Number
    // 500~ : Server Error Code Number
}
