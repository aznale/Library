package org.example.data;


import java.util.ArrayList;

public class DataValues {

    //TODO e.g. A0000 > A9999 > B0000
    //TODO (2) e.g A0680-056 (where 056 is the library specific code)
    public static int idUser = 99;

    //ArrayList<String> languajes2 = new ArrayList<>();

    public static int getIdNumber() {
        return idUser++;
    }

    public static void setIdNumber(int num) {
        idUser = num;
    }


}
