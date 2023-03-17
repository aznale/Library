package org.example.service;

import org.example.manager.BorrowManager;
import org.example.model.Borrow;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BorrowService {

    public static Map<String, Borrow> borrows = new HashMap<>();

    static {
        BorrowManager.createBorrows(borrows,10);
    }

    public Map<String, Borrow> getBorrows(){
        return borrows;
    }
}
