package ru.ibs.homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.homework.entitys.Engine;
import ru.ibs.homework.entitys.Manual;
import ru.ibs.homework.repository.EngineRepository;
import ru.ibs.homework.repository.ManualRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManualServiceImpl implements ManualService{

    @Autowired
    ManualRepository manualRepository;
    @Autowired
    EngineRepository engineRepository;

    @Override
    public void addManual(String type) {
        Manual newManual = new Manual("Новый мануал");

        manualRepository.save(newManual);
    }

    @Override
    public void deleteManual(Integer id) {
        manualRepository.deleteById(id);
    }

    @Override
    public Manual readManual(Integer id) {
        return manualRepository.findManualById(id);
    }

    @Override
    public List<Manual> readAllManuals() {
        return manualRepository.findAll();
    }

    @Override
    public void updateManual(Integer id, String type){
        Manual manual = manualRepository.findManualById(id);
        manual.setType(type);
        manualRepository.save(manual);

    }
}
