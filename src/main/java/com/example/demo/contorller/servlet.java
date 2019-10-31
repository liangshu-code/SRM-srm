package com.example.demo.contorller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class servlet  {

    @GetMapping("/xuguangsai")

    public  String index() {

        return "hello";
    }

    @RequestMapping("/login")
    public  String login() {

        return "login";
    }



}
