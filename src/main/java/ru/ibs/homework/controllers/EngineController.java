package ru.ibs.homework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ibs.homework.entitys.Engine;
import ru.ibs.homework.repository.EngineRepository;

@Controller
@RequestMapping(value ="/api/engine", consumes = {MediaType.ALL_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class EngineController {

    @Autowired
    EngineRepository engineRepository;

    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object createEngine(@RequestBody Engine body){
        return engineRepository.save(body);
    }

    @PostMapping(value = "delete", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEngine(@RequestParam(required = true) Integer id) {
        try {
            if (id != null)
                engineRepository.deleteById(id);
            else
                throw new Exception();
        }catch (Exception e){
            System.out.println("Требуется ID");
        }

    }

    @PostMapping(value = "update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object updateCar(@RequestParam(required = true) Integer id, @RequestBody(required = false) Engine body) {
        Engine engine = engineRepository.findEngineById(id);
        engine.setType(body.getType());
        return engineRepository.save(engine);
    }
}
