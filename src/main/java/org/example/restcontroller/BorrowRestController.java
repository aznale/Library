package org.example.restcontroller;


import org.example.model.Borrow;
import org.example.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/borrow")
public class BorrowRestController {

    @Autowired
    BorrowService borrowService;

    @GetMapping("/borrows")
    public Map<String, Borrow> getAllBorrows(){
        return borrowService.getBorrows();
    }

    @GetMapping("/aBorrow")
    public Borrow getBorrow(@RequestParam("borrowId") String id){
        return borrowService.getBorrow(id);
    }

    @GetMapping("/createBorrow")
    public ResponseEntity<String> createBorrow(@RequestParam("bookId") String bookId, @RequestParam("userId") String userId){

        HttpHeaders headers = new HttpHeaders();
        headers.add("operation", "createBorrow");
        headers.add("version", "api 1.0");


        HashMap<String, String> createdBorrow =  borrowService.createBorrow(bookId, userId);

        if(createdBorrow.get("status").equals("fail")){
            headers.add("statusOperation", "fail");
        }else{
            headers.add("statusOperation", "succes");
        }

        return ResponseEntity.accepted().headers(headers).body(createdBorrow).get("statusDescription");
    }


}
