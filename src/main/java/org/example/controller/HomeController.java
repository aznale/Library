package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.service.LibrarianService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class HomeController {

    @Autowired
    LibrarianService librarianService;
    @Autowired
    UserService userService;
    private final Set<String> sessionsId = Collections.synchronizedSet(new HashSet<>());

    @RequestMapping({"/", "/login"})
    public String getLogin(Model model, HttpSession session) {
        model.addAttribute("users", userService.getAllUsers().values());
        model.addAttribute("librarians", librarianService.getLibrarians().values());

        if (session.getAttribute("isLogin") == null) session.setAttribute("isLogin", false);
        return "login/login";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }

    @RequestMapping("/home")
    public String getHome(Model model, HttpSession session) {
        session.setAttribute("requestCount", getRequestCount(session));
        if ((boolean) session.getAttribute("isLogin")) {
            return "home";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String login(HttpSession session, HttpServletRequest request, @RequestParam("librarianIdFromSelect") String librarianId, @RequestParam("userIdFromSelect") String userId) {

        session.setAttribute("requestCount", getRequestCount(session));

        boolean empty = librarianId.contains("Empty Selection") || userId.contains("Empty Selection");

        if (!((boolean) session.getAttribute("isLogin")) && !empty) {
            this.sessionsId.add(session.getId());

            session.setAttribute("librarianId", librarianId);
            session.setAttribute("userId", userId);
            session.setAttribute("session-creation-timestamp", new Date().toString());
            session.setAttribute("todayDate", new Date().toString());
            session.setAttribute("sessionId", session.getId());
            session.setAttribute("sessionCount", this.sessionsId.size());

            Map<String, String> headerNamesMap = new HashMap<>();

            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String key = headerNames.nextElement();
                String value = request.getHeader(key);
                headerNamesMap.put(key, value);
            }

            session.setAttribute("httpServletRequestHeaders", headerNamesMap);
            session.setAttribute("isLogin", true);

            return "redirect:home";
        } else {
            return "redirect:/";
        }
    }

    private Object getRequestCount(HttpSession session) {
        Integer requestCount = (Integer) session.getAttribute("requestCount");
        requestCount = requestCount != null ? requestCount : 0;
        requestCount++;
        session.setAttribute("requestCount", requestCount);
        return requestCount;
    }
}
