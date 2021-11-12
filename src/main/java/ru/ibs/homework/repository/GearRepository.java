package ru.ibs.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.homework.entitys.Gear;

import java.util.List;

public interface GearRepository extends JpaRepository<Gear, Integer> {
    Gear findGearByEngineId(Integer engineId);

    List<Gear> findGearsByEngineId(Integer engineId);
}
