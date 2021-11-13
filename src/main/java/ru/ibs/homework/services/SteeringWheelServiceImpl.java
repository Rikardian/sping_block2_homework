package ru.ibs.homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.homework.entitys.Car;
import ru.ibs.homework.entitys.SteeringWheel;
import ru.ibs.homework.repository.CarRepository;
import ru.ibs.homework.repository.SteeringWheelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SteeringWheelServiceImpl implements SteeringWheelService{

    @Autowired
    SteeringWheelRepository steeringWheelRepository;
    @Autowired
    CarRepository carRepository;

    @Override
    public void addSteeringWheel(String type) {
        SteeringWheel steeringWheel = new SteeringWheel(type);
        steeringWheelRepository.save(steeringWheel);
    }

    @Override
    public void deleteSteeringWheel(Integer id) {
        Car car = carRepository.findCarBySteeringWheelId(id);
        car.setSteeringWheel(null);
        steeringWheelRepository.deleteById(id);
    }

    @Override
    public List<SteeringWheel> readAllSteeringWheels() {
        return steeringWheelRepository.findAll();
    }

    @Override
    public SteeringWheel readSteeringWheel(Integer id) {
        return steeringWheelRepository.findSteeringWheelById(id);
    }

    @Override
    public void updateSteeringWheel(Integer id, String type){
        SteeringWheel steeringWheel = steeringWheelRepository.findSteeringWheelById(id);
        steeringWheel.setType(type);
        steeringWheelRepository.save(steeringWheel);
    }
}
