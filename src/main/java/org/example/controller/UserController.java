package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    /*@GetMapping("/helloRest/{user}")
    public String helloWorld(@PathVariable String user){
        return "Welcome to the jungle " + user + "!!";
    }*/

    @GetMapping("/helloRest")
    public String helloWorld(){
        return "Welcome to the jungle!";
    }

    @GetMapping("/sumar/{numA}/{numB}")
    public int sumar(@PathVariable int numA,@PathVariable int numB){
        return numA + numB;
    }

}
