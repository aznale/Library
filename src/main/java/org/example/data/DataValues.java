package org.example.data;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataValues {

    //TODO e.g. A0000 > A9999 > B0000
    //TODO (2) e.g A0680-056 (where 056 is the library specific code)
    public static int idUser = 99;
    public static int idBook = 99;
    public static ArrayList<String> language = new ArrayList<>(List.of("Català","Castellà","Anglès"));

    // Works OK Alternative
    // public static ArrayList<String> language2 = new ArrayList<>() {{add("Català");add("Castellà"); add("Anglès");}};

    // No works!
    // public static ArrayList<String> language3 = new ArrayList<String>("Català","Castellà","Anglès");


    public static int getIdNumber() {
        return idUser;
    }

    public static void setIdNumber(int num) {
        idUser = num;
    }

    public static int getIdBook() {
        return idBook;
    }

    public static void setIdBook(int num) {
        idBook = num;
    }



    public static String getLanguage(int index){
        return language.get(index);
    }

    public static String createUUID(){
        UUID uuid = UUID.randomUUID();
        //System.out.println("UUID generated - " + uuid);
        //System.out.println("UUID Version - " + uuid.version());
        return uuid.toString();

    }


}
