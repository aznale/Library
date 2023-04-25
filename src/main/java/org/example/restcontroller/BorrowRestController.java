package org.example.restcontroller;


import org.example.model.Borrow;
import org.example.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
