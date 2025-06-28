package org.example.db;

import org.example.entity.Dish;
import org.example.entity.Table;
import org.example.entity.User;
import org.example.entity.enums.Role;
import org.example.entity.enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataSource {
    public static Scanner scanner = new Scanner(System.in);
    public static Scanner strScanner = new Scanner(System.in);
    public static List<Table> tables = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();
    public static User currentUser = null;

    static {
//        tables.add(new Table("1",1,"", Status.INACTIVE));
//        tables.add(new Table("2",2,"", Status.INACTIVE));
//        tables.add(new Table("3",3,"", Status.INACTIVE));
//        tables.add(new Table("4",4,"", Status.INACTIVE));
//        tables.add(new Table("5",5,"", Status.INACTIVE));
//        tables.add(new Table("6",6,"", Status.INACTIVE));
//        tables.add(new Table("7",7,"", Status.INACTIVE));
//        tables.add(new Table("8",8,"", Status.INACTIVE));
//        tables.add(new Table("9",9,"", Status.INACTIVE));
//        tables.add(new Table("10",10,"", Status.INACTIVE));

        users.add(new User("admin","admin", Role.ADMIN));
        users.add(new User("a", "a", Role.STAFF));

        dishes.add(new Dish("somsa", 10000));
        dishes.add(new Dish("manti", 8000));
        dishes.add(new Dish("mastava", 20000));
        dishes.add(new Dish("lagmon", 22000));
        dishes.add(new Dish("shurva", 25000));

    }
}
