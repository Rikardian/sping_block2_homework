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
    public Gear findGear(Integer id) {
        return gearRepository.findGearById(id);
    }

    @Override
    public List<Gear> findGears() {
        return gearRepository.findGears();
    }

    @Override
    public void addGear(int gearSize) {
        final Gear gear = new Gear(gearSize);
        gearRepository.save(gear);
    }

    @Override
    public void deleteGear(Integer id) {
        gearRepository.deleteById(id);
    }
}
