package org.example.manager;

import com.github.javafaker.Faker;
import org.example.model.Librarian;
import org.example.utils.DataValues;

import java.util.Map;

public class LibrarianManager {

    public static void createLibrarians(Map<String, Librarian> librariansToMap, int librariansNumber){
        Faker faker = new Faker();
        Librarian newLibrarian;
        int sumNewMaxId = DataValues.getIdLibrarian();

        for (int i = 0; i < librariansNumber; i++) {
            newLibrarian = new Librarian(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.random().nextInt(18, 99),
                    faker.address().fullAddress(),
                    ""
            );

            newLibrarian.setIdLibrarian(String.format("%03d",sumNewMaxId));
            sumNewMaxId++;

            librariansToMap.put(newLibrarian.getIdLibrarian(), newLibrarian);
        }

        DataValues.setIdLibrarian(sumNewMaxId);
    }
}
