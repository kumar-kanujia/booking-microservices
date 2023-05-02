package com.example.fromtui;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cont {


    public final ClientSer client;

    public Cont(ClientSer client) {
        this.client = client;
    }

    @GetMapping("hello")
    public String sayHello() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getDetails());
        //client.getHello()
        return "hello";
    }

    @GetMapping("bye")
    public String sayBye() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getDetails());
        return "bye";
    }

    @GetMapping("admin")
    public String admin() {
        return client.getAdmit();
    }
}