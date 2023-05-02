package com.example.fromtui;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="test", url="http://localhost:8080/TEST")
public interface ClientSer {

    @GetMapping("hello")
    public String getHello();

    @GetMapping("admin")
    public String getAdmit();
}
