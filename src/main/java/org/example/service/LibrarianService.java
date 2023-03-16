package org.example.service;

import org.example.manager.LibrarianManager;
import org.example.model.Librarian;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LibrarianService {

    public static Map<String, Librarian> librarians = new HashMap<>();

    static {
        LibrarianManager.createLibrarians(librarians,16);
    }

    public Map<String,Librarian> getLibrarians(){
        return librarians;
    }

    public Librarian getLibrarian(String id){
        return librarians.get(id);
    }

    public void deleteLibrarian(String id){
        librarians.remove(id);
    }

    public void updateLibrarian(String id, Librarian librarian){
        librarian.setIdLibrarian(id);
        librarians.put(id, librarian);
    }
}
