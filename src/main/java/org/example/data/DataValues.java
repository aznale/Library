package org.example.data;




public class DataValues {
    public static int idUser = 99999;

    public static int getIdNumber(){
        return idUser--;
    }

    public static void setIdNumber(int num){
        idUser=num;
    }

}
