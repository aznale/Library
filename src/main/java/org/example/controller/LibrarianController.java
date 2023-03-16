package org.example.controller;

import org.example.model.Librarian;
import org.example.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/librarian")
public class LibrarianController {

    @Autowired
    LibrarianService librarianService;

    @RequestMapping("/librarians")
    public String getLibrarians(Model model){
        model.addAttribute("librarians", librarianService.getLibrarians());
        return "librarianManagerView";
    }

    @RequestMapping("/librarianCard")
    public String librarianCard(@RequestParam("idLibrarian") String id, Model model) {
        Librarian librarianFound = librarianService.getLibrarian(id);
        if (librarianFound != null) {
            model.addAttribute("librarianSendToForm", librarianFound);
            model.addAttribute("messsage", "Librarian found");
        } else {
            model.addAttribute("message", "Librarian not found");
        }
        return "editLibrarian";
    }

    @PostMapping("/updateLibrarian/{idLibrarian}")
    public String updateLibrarian(@PathVariable("idLibrarian") String id, Librarian librarian) {
        Librarian librarianFound = librarianService.getLibrarian(id);
        if (librarianFound != null) {
            librarianService.updateLibrarian(id, librarian);
            return "redirect:/librarian/librarians";
        }
        return "librarian/librarianNotFound";// TODO implement librarianNotFound and this template
    }

    @RequestMapping("/deleteLibrarian")
    public String deleteLibrarian(@RequestParam("idLibrarian") String id){
        Librarian librarianFound = librarianService.getLibrarian(id);
        if(librarianFound!=null){
            librarianService.deleteLibrarian(id);
            return "redirect:/librarian/librarians";
        }
        return "redirect:/librarianNotFound";// TODO implement librarianNotFound and this template
    }


}
