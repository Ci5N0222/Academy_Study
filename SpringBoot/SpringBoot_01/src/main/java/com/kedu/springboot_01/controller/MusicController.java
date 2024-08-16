package com.kedu.springboot_01.controller;

import com.kedu.springboot_01.dto.MusicDTO;
import com.kedu.springboot_01.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// http:localhost/post?id=abc&title=abc...
// http:localhost/post

// {id: "", ... } <-- ResponseBody

// RESTful 서버를 구축할 때 URL 규칙 ( Convention )
// URL은 자원을 명시하고 하고자하는 행동은 Request의 메서드로 지정
// Method - ( C: post, R: get, U: put, D: delete )

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired 
    private MusicService musicService;

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody MusicDTO dto) {
        musicService.post(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<MusicDTO>> list(String title) {
        System.out.println("title ===== "+ title);
        if(title != null) {
            List<MusicDTO> list = musicService.getSearchData(title);
            return ResponseEntity.ok(list);
        }
        List<MusicDTO> list = musicService.getAllData();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicDTO> detail(@PathVariable int id) {
        MusicDTO detail = musicService.getOneData(id);
        return ResponseEntity.ok(detail);
    }
//    @GetMapping("/detail")
//    public ResponseEntity<MusicDTO> detail(int id) {
//        MusicDTO detail = musicService.getOneData(id);
//        return ResponseEntity.ok(detail);
//    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody MusicDTO dto) {
        musicService.update(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        musicService.delete(id);
        return ResponseEntity.ok().build();
    }
//    @DeleteMapping("/delete")
//    public ResponseEntity<Void> delete(int id) {
//        musicService.delete(id);
//        return ResponseEntity.ok().build();
//    }

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
