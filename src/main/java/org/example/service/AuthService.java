package org.example.service;

import org.example.entity.Order;
import org.example.entity.User;
import org.example.entity.enums.Role;

import static org.example.db.DataSource.*;

public class AuthService {
    public void service(){
        while (true){
            System.out.println("login:");
            String login = strScanner.nextLine();
            System.out.println("password:");
            String password = strScanner.nextLine();
            for (User user : users) {
                if (user.getLogin().equals(login) &&
                        user.getPassword().equals(password) &&
                        user.getRole().equals(Role.ADMIN)) {

                    new AdminService().service();
                }
                        else if (user.getLogin().equals(login) &&
                        user.getPassword().equals(password) &&
                        user.getRole().equals(Role.STAFF )) {
                            currentUser = user;
                        new OrderService().service();
                    }
            }
        }
    }
}
