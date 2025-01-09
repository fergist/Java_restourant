package ru.mulla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mulla.entities.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {
}
