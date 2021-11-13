package ru.ibs.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.homework.entitys.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    Car findCarByEngineId(Integer engineId);
    Car findCarBySteeringWheelId(Integer stwId);
    List<Car> findCarByMnfName(String mnfName);
    List<Car> findCarById(Integer id);
    List<Car> findAll();
}
