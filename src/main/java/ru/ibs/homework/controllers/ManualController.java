package ru.ibs.homework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.ibs.homework.entitys.Engine;
import ru.ibs.homework.entitys.Manual;
import ru.ibs.homework.repository.EngineRepository;
import ru.ibs.homework.repository.ManualRepository;
import ru.ibs.homework.services.EngineService;
import ru.ibs.homework.services.ManualService;

@RestController
@RequestMapping(value ="/api/manual", consumes = {MediaType.ALL_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class ManualController {

    @Autowired
    ManualService manualService;


    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createManual(@RequestBody Manual body){
        manualService.addManual(body.getType());
    }

    @PostMapping(value = "delete", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteManual(@RequestParam(required = true) Integer id) {
        manualService.deleteManual(id);
    }

    @PostMapping(value = "update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateManual(@RequestParam(required = true) Integer id, @RequestBody(required = false) Manual body) {
        manualService.updateManual(id, body.getType());
    }

    @GetMapping(value = "read", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showJson(@RequestParam(required = false) Integer id) {
        if (id != null){
            return manualService.readManual(id);
        }
        else {
            return manualService.readAllManuals();
        }
    }
}
