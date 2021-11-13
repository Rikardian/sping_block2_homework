package ru.ibs.homework.services;

import ru.ibs.homework.entitys.Car;
import ru.ibs.homework.entitys.Engine;

import java.util.List;

public interface CarService {

    void addCar(String mnfName, String modelName, String engineType);

    void deleteCar(Integer id);

    List<Car> readAllCar();

    List<Car> readCar(Integer id);

    void updateCar(Integer id, String mnfName, String modelName, Engine engine);
}
