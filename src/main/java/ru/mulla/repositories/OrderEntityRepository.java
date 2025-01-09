package ru.mulla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mulla.entities.OrderEntity;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {
}
