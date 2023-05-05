package com.jfs.recource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("hello")
    String hg(){
        return "hello";
    }

	@GetMapping("admin")
    String fg(){
        return "admin";
    }
}
