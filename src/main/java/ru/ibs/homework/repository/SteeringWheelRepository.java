package ru.ibs.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.homework.entitys.SteeringWheel;

public interface SteeringWheelRepository extends JpaRepository<SteeringWheel, Integer> {
    SteeringWheel findSteeringWheelById(Integer id);
}
