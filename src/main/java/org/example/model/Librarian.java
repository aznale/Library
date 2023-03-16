package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Librarian extends Person{

    private String idLibrarian;

    public Librarian(String name, String surname, int age, String address, String idLibrarian) {
        super(name, surname, age, address);
        this.idLibrarian = idLibrarian;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "idLibrarian='" + idLibrarian + '\'' +
                "} " + super.toString();
    }
}
