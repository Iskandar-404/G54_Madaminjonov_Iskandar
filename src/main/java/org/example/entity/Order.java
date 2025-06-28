package org.example.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Order {
    private final String id = UUID.randomUUID().toString();
    private String tableId;
    private String dishId;
    private Integer count;
    private Integer price;
}
