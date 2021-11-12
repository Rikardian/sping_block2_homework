package ru.ibs.homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.homework.entitys.Car;
import ru.ibs.homework.entitys.Gear;
import ru.ibs.homework.repository.GearRepository;

import java.util.List;

@Service
public class GearServiceImpl implements GearService{

    @Autowired
    private GearRepository gearRepository;

    @Override
    public Gear findGear(Car car) {

        return gearRepository.findGearByEngineId(car.getEngine().getId());
    }

    @Override
    public List<Gear> findGears(Car car) {
        return gearRepository.findGearsByEngineId(car.getEngine().getId());
    }
}
