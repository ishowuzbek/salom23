package org.example.adressline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int id=userId++;
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    public static int userId=1;

    public User(String firstName, String lastName, String phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.password = password;
    }
}
