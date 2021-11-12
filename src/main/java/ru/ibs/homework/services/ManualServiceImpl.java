package ru.ibs.homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.homework.entitys.Engine;
import ru.ibs.homework.entitys.Manual;
import ru.ibs.homework.repository.ManualRepository;

@Service
public class ManualServiceImpl implements ManualService{

    @Autowired
    ManualRepository manualRepository;


    @Override
    public Manual addManual(String type, Engine engine) {
        Manual newManual = new Manual("Manual for" + engine.getType());

        return manualRepository.save(newManual);
    }
}
