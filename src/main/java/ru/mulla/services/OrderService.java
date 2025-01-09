package ru.mulla.services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mulla.entities.Order;
import ru.mulla.entities.OrderEntity;
import ru.mulla.repositories.OrderEntityRepository;
import ru.mulla.repositories.OrderRepository;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {
    private OrderRepository orderRepository;
    private OrderEntityRepository orderEntityRepository;

    public Iterable<Order> getOrdersByUserId(long userId) {
        return orderRepository.findAllByUserId(userId);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public void saveOrderEntity(OrderEntity orderEntity) {
        orderEntityRepository.save(orderEntity);
    }
}
