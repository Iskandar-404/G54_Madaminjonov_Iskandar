package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Table {
    private final String id = UUID.randomUUID().toString();
    private Integer tableNumber;
    private List<Order> orders = new ArrayList<>();
    private String staffId;
    private Integer overallPrice = 0;
    private Status status;

    public Table(Integer tableNumber, Status status) {
        this.tableNumber = tableNumber;
        this.status = status;
    }
}
