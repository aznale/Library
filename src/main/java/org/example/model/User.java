package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Person{

    private ArrayList<String> userBorrows;
    private String idMember;

    public User(String name, String surname, int age, String address, String idMember) {
        super(name, surname, age, address);
        this.idMember = idMember;
        this.userBorrows = new ArrayList<>();
    }

    public String getNameSurname(){
        return getName() + ' ' + getSurname();
    }

    public void update(User other) {
        Class<?> clazz = getClass();
        Field[] fields = clazz.getDeclaredFields();
        System.out.println(clazz);
        System.out.println(Arrays.toString(fields));
        Arrays.stream(fields)
                .filter(field -> {
                    try {
                        Object value = field.get(other);
                        return value != null &&
                                (!(value instanceof Number) || ((Number) value).intValue() != 0) &&
                                (!(value instanceof Boolean) || (Boolean) value);
                    } catch (IllegalAccessException e) {
                        return false;
                    }
                })
                .forEach(field -> {
                    try {
                        field.set(this, field.get(other));
                    } catch (IllegalAccessException e) {
                        // Handle exception
                    }
                });
    }

    @Override
    public String toString() {
        return "User{" +
                "idMember='" + idMember + '\'' +
                "} " + super.toString();
    }


}
