package ru.ibs.homework.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.homework.entitys.Engine;
import ru.ibs.homework.entitys.Manual;

import java.util.List;

public interface EngineRepository extends JpaRepository<Engine, Integer> {
    List<Engine> findAll();
    List<Engine> findEngineById(Integer id);
}
