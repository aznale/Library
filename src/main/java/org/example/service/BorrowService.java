package org.example.service;

import org.example.manager.BorrowManager;
import org.example.model.Borrow;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class BorrowService {

    public static Map<String, Borrow> borrows = new HashMap<>();

    static {
        BorrowManager.createBorrows(borrows,20);
    }

    public Map<String, Borrow> getBorrows(){
        return borrows;
    }

    public Borrow getBorrow(String id){
        return borrows.get(id);
    }

    public void createBorrow(Borrow borrow){

    }

    public Map<String, Borrow> getBorrowsById(ArrayList<String> idBorrowsByUser){
        Map<String, Borrow> borrowsById = new HashMap<>();
        for ( String idBorrow: idBorrowsByUser) {
            for (String borrow : borrows.keySet()) {
                if(borrow.equals(idBorrow)){
                    borrowsById.put(idBorrow,borrows.get(borrow));
                }
            }
        }
        return  borrowsById;
    }



}
