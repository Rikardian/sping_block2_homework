package ru.ibs.homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.homework.entitys.Car;
import ru.ibs.homework.entitys.Engine;
import ru.ibs.homework.entitys.Gear;
import ru.ibs.homework.entitys.Manual;
import ru.ibs.homework.repository.CarRepository;
import ru.ibs.homework.repository.EngineRepository;

import java.util.List;

@Service
public class EngineServiceImpl implements EngineService {

    @Autowired
    private EngineRepository engineRepository;

    @Autowired
    private CarRepository carRepository;


    @Override
    public void addEngine(String type) {

        final Engine newEngine = new Engine(type);


        Manual cylinderHeadManual = new Manual("Cylinder head manual for " + type);
        newEngine.getManuals().add(cylinderHeadManual);
        cylinderHeadManual.getEngines().add(newEngine);
        Manual electricManual = new Manual("Electrics manual for " + type);
        newEngine.getManuals().add(electricManual);
        electricManual.getEngines().add(newEngine);

        engineRepository.save(newEngine);
    }

    @Override
    public void deleteEngine(Integer id) {
        Car car = carRepository.findCarByEngineId(id);
        car.setEngine(null);
        engineRepository.deleteById(id);
    }

    @Override
    public List<Engine> readAllEngines() {
        return engineRepository.findAll();
    }

    @Override
    public List<Engine> readEngine(Integer id) {
        return engineRepository.findEngineById(id);
    }

    @Override
    public void updateEngine(Integer id, String type) {
        List<Engine> newEngine = engineRepository.findEngineById(id);
        newEngine.get(0).setType(type);
        engineRepository.save(newEngine.get(0));
    }
}
