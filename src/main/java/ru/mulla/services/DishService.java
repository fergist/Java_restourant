package ru.mulla.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mulla.entities.Dish;
import ru.mulla.repositories.DishRepository;

@Service
@AllArgsConstructor
@Slf4j
public class DishService {
    private DishRepository dishRepository;

    public Iterable<Dish> findAll() {
        return dishRepository.findAll();
    }
}
