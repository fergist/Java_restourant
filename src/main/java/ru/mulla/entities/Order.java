package ru.mulla.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String orderDate;
    private int totalCost;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @OneToMany
    private List<OrderEntity> orderEntities;

    public void addOrderEntity(OrderEntity orderEntity) {
        orderEntities.add(orderEntity);
    }
}
