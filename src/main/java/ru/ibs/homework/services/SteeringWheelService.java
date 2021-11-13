package ru.ibs.homework.services;

import ru.ibs.homework.entitys.SteeringWheel;

import java.util.List;
import java.util.Optional;

public interface SteeringWheelService {

    void addSteeringWheel(String type);

    void deleteSteeringWheel(Integer id);

    List<SteeringWheel> readAllSteeringWheels();

    SteeringWheel readSteeringWheel(Integer id);

    void updateSteeringWheel(Integer id, String type);
}
