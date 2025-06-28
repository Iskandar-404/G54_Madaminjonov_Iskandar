package org.example.service;

import org.example.entity.Dish;
import org.example.entity.Order;
import org.example.entity.Table;
import org.example.entity.enums.Status;

import static org.example.db.DataSource.*;

public class OrderService {
    public void service(){
        while (true) {
            System.out.println("""
                    0 exit
                    1 take order
                    2 my orders
                    """);
            switch (scanner.nextInt()){
                case 0 -> {
                    return;
                }
                case 1 -> {
                    takeOrder();
                }
                case 2 -> {
                    myOrders();
                }
            }
        }
    }

    private void myOrders() {
        for (Table table : tables) {
            if (table.getStaffId().equals(currentUser.getId()) &&
                    table.getStatus().equals(Status.ACTIVE)){
                System.out.println(table);
            }
        }
        while (true) {
            System.out.println("""
                    0 exit
                    1 inactive the table
                    """);
            switch (scanner.nextInt()){
                case 0 -> {
                    return;
                }
                case 1 -> {
                    System.out.println("table id:");
                    String id = strScanner.nextLine();
                    for (Table table : tables) {
                        if (table.getStaffId().equals(currentUser.getId()) &&
                                table.getId().equals(id)){
                            table.setStatus(Status.INACTIVE);
                        }
                    }
                }
            }
        }
    }

    private void takeOrder() {
        System.out.println("table number(1-10):");
        Integer num = scanner.nextInt();
        if (num < 1 || num > 10){
            System.out.println("ERROR");
            return;
        }
        for (Table table : tables) {
            if (table.getTableNumber() == num &&
                    table.getStatus().equals(Status.ACTIVE) &&
                    table.getStaffId().equals(currentUser.getId())){
                addOrder(table);
            }
            else if (table.getTableNumber() == num &&
                    table.getStatus().equals(Status.INACTIVE)){
                Table tb = new Table();
                tb.setTableNumber(num);
                tb.setStaffId(currentUser.getId());
                newOrder(tb);
            }
        }
    }

    private void newOrder(Table table) {
        addOrder(table);
    }

    private Dish checkId(String id) {
        for (Dish dish : dishes) {
            if (dish.getId().equals(id)){
                return dish;
            }
        }
        return null;
    }

    private void addOrder(Table table) {
        Order order = new Order();
        order.setTableId(table.getId());
        while (true) {
            System.out.println("""
                    0 exit
                    1 add order
                    """);
            switch (scanner.nextInt()){
                case 0 -> {
                    return;
                }
                case 1 -> {
                    while (true){
                        System.out.println("""
                            0 exit
                            1 add
                            """);
                        switch (scanner.nextInt()){
                            case 0 -> {
                                return;
                            }
                            case 1-> {
                                dishes.forEach(System.out::println);
                                System.out.println("Dish ID:");
                                String id = strScanner.nextLine();
                                Dish dish = checkId(id);
                                if (dish == null){
                                    System.out.println("not found");
                                    return;
                                }
                                order.setDishId(dish.getId());
                                System.out.println("count:");
                                Integer count = scanner.nextInt();
                                if (count <= 0){
                                    System.out.println("ERROR");
                                    return;
                                }
                                order.setCount(count);
                                order.setPrice(dish.getPrice()*count);
                                table.setOverallPrice(table.getOverallPrice()+dish.getPrice()*count);
                                table.getOrders().add(order);
                                currentUser.setCountOfOrders(currentUser.getCountOfOrders()+1);
                                currentUser.setOrdersPrice(currentUser.getOrdersPrice()+dish.getPrice()*count);
                                table.setStatus(Status.ACTIVE);
                            }
                        }
                    }
                }
            }
        }
    }
}
