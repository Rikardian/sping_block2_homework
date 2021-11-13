package ru.ibs.homework.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.homework.entitys.*;
import ru.ibs.homework.repository.CarRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void addCar(String mnfName, String modelName, String engineType) {
        final Car newCar = new Car(mnfName, modelName);

        final SteeringWheel steeringWheel = new SteeringWheel(String.join(" ", newCar.getMnfName(), newCar.getModelName(), "steering wheel"));
        newCar.setSteeringWheel(steeringWheel);

        Engine engine = new Engine(engineType);
        newCar.setEngine(engine);

        Manual cylinderHeadManual = new Manual("Cylinder head manual for " + engineType);
        engine.getManuals().add(cylinderHeadManual);
        cylinderHeadManual.getEngines().add(engine);
        Manual electricManual = new Manual("Electrics manual for " + engineType);
        engine.getManuals().add(electricManual);
        electricManual.getEngines().add(engine);

        carRepository.save(newCar);
    }

    @Override
    public void deleteCar(Integer id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> readAllCar() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> readCar(Integer id) {
        return carRepository.findCarById(id);
    }

    @Override
    public void updateCar(Integer id, String mnfName, String modelName, Engine engine) {
        List<Car> newCar = carRepository.findCarById(id);
        newCar.get(0).setMnfName(mnfName);
        newCar.get(0).setModelName(modelName);
        newCar.get(0).setEngine(engine);
        carRepository.save(newCar.get(0));
    }


}
