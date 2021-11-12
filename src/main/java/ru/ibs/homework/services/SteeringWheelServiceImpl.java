package ru.ibs.homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.homework.entitys.SteeringWheel;
import ru.ibs.homework.repository.SteeringWheelRepository;

@Service
public class SteeringWheelServiceImpl implements SteeringWheelService{

    @Autowired
    SteeringWheelRepository steeringWheelRepository;

    @Override
    public SteeringWheel addSteeringWheel(String type) {
        SteeringWheel steeringWheel = new SteeringWheel(type);

        return steeringWheelRepository.save(steeringWheel);
    }
}
