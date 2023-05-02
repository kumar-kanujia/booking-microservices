package com.jfs.recource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("hello")
    String hg(){
        return "hello";
    }
    @PostMapping("admin")
    String fg(){
        return "admin";
    }
}
