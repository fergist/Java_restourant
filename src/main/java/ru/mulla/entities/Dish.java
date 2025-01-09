package ru.mulla.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "dishes")
@Getter
@Setter
public class Dish {
    @Id
    private int id;
    private String name;
    private String dishPrice;
    @Column(length = 1000)
    @OneToMany(mappedBy = "dish")
    private List<OrderEntity> orderEntity;
}
