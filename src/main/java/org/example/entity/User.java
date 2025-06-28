package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.enums.Role;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private final String id = UUID.randomUUID().toString();
    private Role role;
    private String name;
    private String surname;
    private String login;
    private String password;
    private Integer countOfOrders = 0;
    private Integer ordersPrice = 0;

    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
