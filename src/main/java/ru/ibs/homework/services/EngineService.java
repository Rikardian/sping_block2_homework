package ru.ibs.homework.services;

import ru.ibs.homework.entitys.Engine;

import java.util.List;

public interface EngineService {
    void addEngine(String type);

    void deleteEngine(Integer id);

    List<Engine> readAllEngines();

    List<Engine> readEngine(Integer id);

    void updateEngine(Integer id, String type);
}
