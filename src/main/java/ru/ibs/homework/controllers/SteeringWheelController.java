package ru.ibs.homework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.ibs.homework.entitys.Engine;
import ru.ibs.homework.entitys.SteeringWheel;
import ru.ibs.homework.repository.EngineRepository;
import ru.ibs.homework.repository.SteeringWheelRepository;
import ru.ibs.homework.services.EngineService;
import ru.ibs.homework.services.SteeringWheelService;

@Controller
@RequestMapping(value ="/api/steeringwheel", consumes = {MediaType.ALL_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class SteeringWheelController {

    @Autowired
    SteeringWheelRepository steeringWheelRepository;
    @Autowired
    SteeringWheelService steeringWheelService;

    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createSteeringWheel(@RequestBody SteeringWheel body){
        steeringWheelService.addSteeringWheel(body.getType());
    }

    @PostMapping(value = "delete", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSteeringWheel(@RequestParam(required = true) Integer id) {
        steeringWheelService.deleteSteeringWheel(id);
    }

    @PostMapping(value = "update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object updateSteeringWheel(@RequestParam(required = true) Integer id, @RequestBody(required = false) SteeringWheel body) {
        SteeringWheel steeringWheel = steeringWheelRepository.findSteeringWheelById(id);
        steeringWheel.setType(body.getType());
        return steeringWheelRepository.save(steeringWheel);
    }

    @GetMapping(value = "read", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showJson(@RequestParam(required = false) Integer id) {
        if (id != null){
            return steeringWheelService.readSteeringWheel(id);
        }
        else {
            return steeringWheelService.readAllSteeringWheels();
        }
    }
}
