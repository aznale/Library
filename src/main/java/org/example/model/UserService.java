package org.example.model;

import org.example.manager.UserManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public Iterable<User> getUsers(){
        Iterable<User> users = (Iterable<User>) UserManager.getAllUsers();

        return users;
    }

}
