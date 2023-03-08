package org.example.service;

import org.example.manager.UserManager;
import org.example.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    public static Map<String, User> users = new HashMap<>();

    static {
        UserManager.createUsers(20);
    }

    public static Map<String, User> getAllUsers() {
        return users;
    }
}
