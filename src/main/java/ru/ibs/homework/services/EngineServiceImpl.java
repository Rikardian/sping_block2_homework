package ru.ibs.homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.homework.entitys.Engine;
import ru.ibs.homework.entitys.Gear;
import ru.ibs.homework.entitys.Manual;
import ru.ibs.homework.repository.EngineRepository;

@Service
public class EngineServiceImpl implements EngineService{

    @Autowired
    private EngineRepository engineRepository;


    @Override
    public Engine addEngine(String type) {

        final Engine newEngine = new Engine(type);
        for (int i = 5; i <= 10; i++) {
            final Gear gear = new Gear(i);
            gear.setEngine(newEngine);
            newEngine.getGears().add(gear);
        }

        Manual cylinderHeadManual = new Manual("Cylinder head manual for " + type);
        newEngine.getManuals().add(cylinderHeadManual);
        cylinderHeadManual.getEngines().add(newEngine);
        Manual electricManual = new Manual("Electrics manual for " + type);
        newEngine.getManuals().add(electricManual);
        electricManual.getEngines().add(newEngine);

        return engineRepository.save(newEngine);
    }
}
