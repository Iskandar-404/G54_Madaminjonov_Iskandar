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
    private String id;
    private Integer tableNumber;
    private List<Order> orders = new ArrayList<>();
    private String staffId;
    private Integer overallPrice = 0;
    private Status status;

    public Table(String id, Integer tableNumber, String staffId, Status status) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.staffId = staffId;
        this.status = status;
    }
}
