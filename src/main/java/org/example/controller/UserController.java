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
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        //System.out.println(UserService.getAllUsers());
        return "userManagerView";
    }

    @RequestMapping("/emptyCreateUser")
    public String emptyCreateUser() {
        return "createUser";
    }

    @RequestMapping("/createUser")
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:users";
    }

    @RequestMapping("/userCard")
    public String userCard(@RequestParam("idUser") String id, Model model) {
        User userFound = userService.getUser(id);
        if (userFound != null) {
            model.addAttribute("userSendToForm", userFound);
            model.addAttribute("messsage", "User found");
        } else {
            model.addAttribute("message", "User not found");
        }
        return "editUser";
    }

    @PostMapping("/updateUser/{idUser}")
    public String updateUser(@PathVariable("idUser") String id, User user) {
        User userFound = userService.getUser(id);
        //System.out.println(userFound);
        if (userFound != null) {
            userService.updateUser(id, user);
            //System.out.println(userService.getAllUsers());
            return "redirect:/user/users";
        }
        return "user/userNotFound";// TODO implement userNotFound and this template
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("idUser") String id) {
        User userFound = userService.getUser(id);
        if (userFound != null) {
            userService.delateUser(id);
            return "redirect:/user/users";
        }
        return "user/userNotFound"; // TODO implement userNotFound and this template
    }
}
