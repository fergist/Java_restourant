package ru.mulla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mulla.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Iterable<Order> findAllByUserId(long customUserId);
}
