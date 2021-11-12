package ru.ibs.homework.services;

import ru.ibs.homework.entitys.Car;

public interface CarService {
    Car addCar(String mnfName, String modelName, String engineType);
}
