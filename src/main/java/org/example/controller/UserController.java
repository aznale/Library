package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/helloRest")
    public String helloWorld(){
        return "Welcome to the jungle!";
    }
}
