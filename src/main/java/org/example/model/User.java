package org.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class User extends Person{
    private String idMember;

    public User(String name, String surname, int age, String address, String idMember) {
        super(name, surname, age, address);
        this.idMember = idMember;
    }

    @Override
    public String toString() {
        return "User{" +
                "idMember='" + idMember + '\'' +
                "} " + super.toString();
    }
}
