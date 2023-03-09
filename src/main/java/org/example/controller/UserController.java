package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", UserService.getAllUsers());
        //System.out.println(UserService.getAllUsers());
        return "userManagerView";
    }

    @RequestMapping("/emptyCreateUser")
    public  String emptyCreateUser(){
        return "createUser";
    }

    @RequestMapping("/createUser")
    public String createUser(User user){
        userService.createUser(user);
        return "redirect:users";
    }


}
