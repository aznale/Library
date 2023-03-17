package org.example.controller;

import org.example.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    BorrowService borrowService;

    @RequestMapping("/borrows")
    public String getBorrows(Model model){
        model.addAttribute("borrows", borrowService.getBorrows());
        return "borrowManagerView";
    }
}
