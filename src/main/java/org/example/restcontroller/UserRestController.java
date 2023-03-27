package org.example.restcontroller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Map<String, User> getAllUsers(){
        return userService.getAllUsers();
    }


}
