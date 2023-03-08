package org.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("hello")
    public String helloHandler(){
        return "hello";
    }

    @RequestMapping("userManagerView")
    public  String userManagerView(){
        return "userManagerView";
    }
}
