package org.example.restcontroller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/aUser")
    public User getUser(@RequestParam("userId") String id){
        return  userService.getUser(id);
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user){
        userService.createUser(user);
        return "User created: \n" + userService.getUser(user.getIdMember());
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") String id){
        return  userService.delateUser(id);
    }


    @PutMapping("/updateUser/{id}")
    public String updateUser(@PathVariable String id, @RequestBody User dataUser){
        return userService.updateUser(id, dataUser);
    }


}
