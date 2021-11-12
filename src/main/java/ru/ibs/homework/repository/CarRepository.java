package ru.ibs.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.homework.entitys.Car;

public interface CarRepository extends JpaRepository<Car,Integer> {
    Car findCarById(Integer id);
}
