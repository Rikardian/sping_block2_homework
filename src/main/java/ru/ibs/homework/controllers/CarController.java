package ru.ibs.homework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.ibs.homework.entitys.Car;
import ru.ibs.homework.repository.CarRepository;
import ru.ibs.homework.services.CarService;

import java.util.Collections;


@Controller
@RequestMapping(value ="/api/car", consumes = {MediaType.ALL_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class CarController {


    @Autowired
    CarService carService;
    @Autowired
    CarRepository carRepository;

    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createCar(@RequestBody Car body){
        carService.addCar(body.getMnfName(), body.getModelName(), body.getEngine().getType());
    }

    @PostMapping(value = "delete", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCar(@RequestParam(required = true) Integer id) {
        carService.deleteCar(id);

    }

    @PostMapping(value = "update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object updateCar(@RequestParam(required = true) Integer id, @RequestBody(required = false) Car body) {
        Car newCar = carRepository.findCarById(id);
        newCar.setMnfName(body.getMnfName());
        newCar.setModelName(body.getModelName());
        newCar.setEngine(body.getEngine());
        return carRepository.save(newCar);
    }

    @GetMapping(value = "read", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showJson(@RequestParam(required = false) Integer id) {
        if (id != null){
            return carService.readCar(id);
        }
        else {
            return carService.readAllCar();
        }
    }



}
