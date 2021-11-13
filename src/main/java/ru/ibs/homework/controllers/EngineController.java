package ru.ibs.homework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.ibs.homework.entitys.Engine;
import ru.ibs.homework.repository.EngineRepository;
import ru.ibs.homework.services.CarService;
import ru.ibs.homework.services.EngineService;

import java.util.List;

@Controller
@RequestMapping(value ="/api/engine", consumes = {MediaType.ALL_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class EngineController {

    @Autowired
    EngineService engineService;

    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createEngine(@RequestBody Engine body){
        engineService.addEngine(body.getType());
    }

    @PostMapping(value = "delete", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEngine(@RequestParam(required = true) Integer id) {
        engineService.deleteEngine(id);
    }

    @PostMapping(value = "update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateCar(@RequestParam(required = true) Integer id, @RequestBody(required = false) Engine body) {
        engineService.updateEngine(id, body.getType());
    }

    @GetMapping(value = "read", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showJson(@RequestParam(required = false) Integer id) {
        if (id != null){
            return engineService.readEngine(id);
        }
        else {
            return engineService.readAllEngines();
        }
    }
}
