package org.example.service;

import org.example.model.User;
import org.example.utils.DataValues;
import org.example.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    public static Map<String, User> users = new HashMap<>();

    static {
        Utils.createUsers(users, 20);
    }

    public Map<String, User> getAllUsers() {
        return users;
    }

    public void createUser(User user) {
        int sumNewMaxId = DataValues.getIdNumber();
        String stringSumNewMaxId = String.format("%04d", sumNewMaxId);
        user.setIdMember(stringSumNewMaxId);
        user.setUserBorrows(new ArrayList<>());
        users.put(stringSumNewMaxId, user);
        DataValues.setIdNumber(sumNewMaxId + 1);
    }

    public User getUser(String id) {
        return users.get(id);
    }


    public String updateUser(String id, User dataUser) {
        if(users.get(id) != null){
            users.get(id).update(dataUser);
            return "User Update \n" + users.get(id).toString();
        }else{
            return "Faillure Update User";
        }
    }

    public String delateUser(String id) {
        String response;
        if (users.get(id).getUserBorrows().isEmpty()) {
            response = "User deleted: \n" + users.get(id).toString();
            users.remove(id);
        }else{
            response = users.get(id).getNameSurname() + " have borrows. Unable to delete it.";
        }
        
        return response;
    }


}
