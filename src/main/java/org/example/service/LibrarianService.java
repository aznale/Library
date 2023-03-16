package org.example.service;

import org.example.manager.LibrarianManager;
import org.example.model.Librarian;
import org.example.utils.DataValues;
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

    public void createLibrarian(Librarian librarian){
        int sumNewMaxId = DataValues.getIdLibrarian();
        String stringSumNewMaxId = String.format("%03d",sumNewMaxId);
        librarian.setIdLibrarian(stringSumNewMaxId);
        librarians.put(stringSumNewMaxId,librarian);
        DataValues.setIdLibrarian(sumNewMaxId+1);
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
