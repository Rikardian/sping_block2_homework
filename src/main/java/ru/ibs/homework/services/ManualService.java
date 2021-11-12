package ru.ibs.homework.services;

import ru.ibs.homework.entitys.Engine;
import ru.ibs.homework.entitys.Manual;

import java.util.List;

public interface ManualService {

    void addManual(String type);

    void deleteManual(Integer id);

    Manual readManual(Integer id);

    List<Manual> readAllManuals();

}
