package ru.ibs.homework.services;

import ru.ibs.homework.entitys.Car;
import ru.ibs.homework.entitys.Gear;

import java.util.List;

public interface GearService {
    Gear findGear(Car car);
    List<Gear> findGears(Car car);
}
