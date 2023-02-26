package org.example;

import org.example.data.DataValues;
import org.example.manager.UserManager;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        UserManager.createUsers(4);

        System.out.println(DataValues.getIdNumber());

        UserManager.createUsers(7);

        System.out.println(DataValues.getIdNumber());

        ArrayList<String> languajes = new ArrayList<>();
        languajes.add("Castellà");
        languajes.add("Català");
        System.out.println(languajes);

    }
}
