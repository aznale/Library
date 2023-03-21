package org.example.controller;

import jakarta.servlet.http.HttpSession;
import org.example.service.LibrarianService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    LibrarianService librarianService;
    @Autowired
    UserService userService;
    private final Set<String> sessionsId = Collections.synchronizedSet(new HashSet<>());

    @RequestMapping({"/","/login"})
    public String getLogin(Model model, HttpSession session){
        model.addAttribute("users", userService.getAllUsers().values());
        model.addAttribute("librarians",librarianService.getLibrarians().values());

        if(session.getAttribute("isLogin")== null) session.setAttribute("isLogin",false);
        return "login/login";
    }

    @RequestMapping("/home")
    public String gethome(Model model){
        model.addAttribute("todayDate", new Date().toString());
        return "home";
    }
}
