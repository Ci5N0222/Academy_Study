package com.kedu.springboot_01.controller;

import com.kedu.springboot_01.dto.PublishDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FilesController {

//    @PostMapping
//    public void write(String text, MultipartFile[] files) {
//        System.out.println("text === " + text);
//        for(MultipartFile file : files) {
//            System.out.println("file === " + file.getOriginalFilename());
//        }
//    }

    @PostMapping
    public void write(@RequestBody PublishDTO dto) {
        System.out.println("publish ==== " + dto.getPublish());
    }

}
