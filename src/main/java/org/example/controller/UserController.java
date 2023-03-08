package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.example.utils.DataValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.example.manager.UserManager.createUsers;
import static org.example.manager.UserManager.users;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /*@GetMapping("/users")
    public Map<String, User> listingAllUsers(Model model) {
        if (users.isEmpty()) {
            createUsers(10);
        }
        model.addAttribute("listAllUsers", users);
        return users;
    }*/
    @RequestMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", UserService.getAllUsers());
        return "user/users";
    }

    @GetMapping("/users/{getUser}")
    public User getUser(@PathVariable String getUser) {
        for (Map.Entry<String, User> user : users.entrySet()) {
            if (user.getValue().getName().equalsIgnoreCase(getUser)) {
                return user.getValue();
            }
        }
        return null;
    }

    @DeleteMapping("/users/{deleteUser}")
    public void deleteUser(@PathVariable String deleteUser) {
        for (Map.Entry<String, User> user : users.entrySet()) {
            if (user.getValue().getName().equalsIgnoreCase(deleteUser)) {
                users.remove(user.getKey());
            }
        }
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        String intId = String.format("%04d",Integer.parseInt(String.valueOf(DataValues.getIdNumber())));
        user.setIdMember(intId);
        users.put(intId, user);
        DataValues.setIdNumber(Integer.parseInt(intId)+1);
    }

    //https://www.youtube.com/watch?v=RfLx9RYjJA8&t=2005s
}
