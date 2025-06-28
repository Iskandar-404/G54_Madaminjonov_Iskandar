package org.example.entity;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Dish {
    private final String id = UUID.randomUUID().toString();
    private String name;
    private Integer price;

    public Dish(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
