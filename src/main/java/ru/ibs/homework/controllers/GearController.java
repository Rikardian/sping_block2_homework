package ru.ibs.homework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.ibs.homework.entitys.Engine;
import ru.ibs.homework.entitys.Gear;
import ru.ibs.homework.repository.EngineRepository;
import ru.ibs.homework.repository.GearRepository;
import ru.ibs.homework.services.EngineService;
import ru.ibs.homework.services.GearService;

@Controller
@RequestMapping(value ="/api/gear", consumes = {MediaType.ALL_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class GearController {

    @Autowired
    GearRepository gearRepository;
    @Autowired
    GearService gearService;

    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createGear(@RequestBody Gear body){
        gearService.addGear(body.getGearSize());
    }

    @PostMapping(value = "delete", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteGear(@RequestParam(required = true) Integer id) {
        gearService.deleteGear(id);
    }

    @PostMapping(value = "update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object updateCar(@RequestParam(required = true) Integer id, @RequestBody(required = false) Gear body) {
        Gear gear = gearRepository.findGearById(id);
        gear.setGearSize(body.getGearSize());
        return gearRepository.save(gear);
    }

    @GetMapping(value = "read", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showJson(@RequestParam(required = false) Integer id) {
        if (id != null){
            return gearService.findGear(id);
        }
        else {
            return gearService.findGears();
        }
    }
}
