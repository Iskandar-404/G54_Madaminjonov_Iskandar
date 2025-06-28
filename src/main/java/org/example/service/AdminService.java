package org.example.service;

import org.example.entity.Dish;
import org.example.entity.Order;
import org.example.entity.Table;
import org.example.entity.User;
import org.example.entity.enums.Role;

import static org.example.db.DataSource.*;

public class AdminService {
    public void service(){
        while (true) {
            System.out.println("""
                    0 exit
                    1 add to menu
                    2 add staff
                    3 show orders
                    4 statistic of staffs
                    """);
            switch (scanner.nextInt()){
                case 0 -> {
                    return;
                }
                case 1 -> {
                    addDish();
                }
                case 2 -> {
                    addStaff();
                }
                case 3 -> {
                    showOrders();
                }
                case 4 -> {
                    statistic();
                }
            }
        }
    }

    private void statistic() {
        for (User user : users) {
            if (!user.getRole().equals(Role.ADMIN)){
                System.out.println(user);
            }
        }
    }

    private void showOrders() {
        for (Table table : tables) {
            for (Order order : table.getOrders()) {
                System.out.println(order);
            }
        }
    }

    private void addStaff() {
        User user = new User();
        System.out.println("name:");
        user.setName(strScanner.nextLine());
        System.out.println("surname:");
        user.setSurname(strScanner.nextLine());
        System.out.println("login:");
        user.setLogin(strScanner.nextLine());
        System.out.println("password:");
        user.setPassword(strScanner.nextLine());
        user.setRole(Role.STAFF);
        user.setOrdersPrice(0);
        user.setCountOfOrders(0);
        users.add(user);
    }

    private void addDish() {
        Dish dish = new Dish();
        System.out.println("name:");
        dish.setName(strScanner.nextLine());
        System.out.println("price:");
        dish.setPrice(scanner.nextInt());
        dishes.add(dish);
    }
}
