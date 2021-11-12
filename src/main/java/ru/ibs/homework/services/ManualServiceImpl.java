package ru.ibs.homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.homework.entitys.Engine;
import ru.ibs.homework.entitys.Manual;
import ru.ibs.homework.repository.ManualRepository;

import java.util.List;

@Service
public class ManualServiceImpl implements ManualService{

    @Autowired
    ManualRepository manualRepository;


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
}
