package org.example.service;

import org.example.manager.UserManager;
import org.example.model.User;
import org.example.utils.DataValues;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    public static Map<String, User> users = new HashMap<>();

    static {
        UserManager.createUsers(users,20);
    }

    public Map<String, User> getAllUsers() {
        return users;
    }

    public void createUser(User user) {
        int sumNewMaxId = DataValues.getIdNumber();
        String stringSumNewMaxId = String.format("%04d",sumNewMaxId);
        user.setIdMember(stringSumNewMaxId);
        users.put(stringSumNewMaxId,user);
        DataValues.setIdNumber(sumNewMaxId+1);
    }

    public User getUser(String id) {
        return users.get(id);
    }


    public void updateUser(String id, User user) {
        user.setIdMember(id);
        users.put(id,user);
    }

    public void delateUser(String id) {
        users.remove(id);
    }


}
