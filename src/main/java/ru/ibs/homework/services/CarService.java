package ru.ibs.homework.services;

import ru.ibs.homework.entitys.Car;

import java.util.List;

public interface CarService {

    void addCar(String mnfName, String modelName, String engineType);

    void deleteCar(Integer id);

    List<Car> readAllCar();

    Car readCar(Integer id);


}
