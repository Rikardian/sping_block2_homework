package ru.ibs.homework.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.homework.entitys.Engine;

public interface EngineRepository extends JpaRepository<Engine, Integer> {
    Engine findEngineById(Integer id);
}
