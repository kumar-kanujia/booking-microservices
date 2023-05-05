package com.example.fromtui.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gateway", url = "http://localhost:8010/TEST")
public interface ClientSer {

    @GetMapping("hello")
    public String getHello();

    @GetMapping("admin")
    public String getAdmit();
}
