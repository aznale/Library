package org.example.utils;

import java.util.Scanner;

public class Utils {

    public static String askString(Scanner reader, String question){
        System.out.println(question);
        return reader.nextLine();
    }

    public static int askInt(Scanner reader, String question){
        System.out.println(question);
        return  Integer.parseInt(reader.nextLine());

    }
}
