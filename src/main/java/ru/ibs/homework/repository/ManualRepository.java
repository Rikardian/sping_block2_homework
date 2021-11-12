package ru.ibs.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.homework.entitys.Manual;

public interface ManualRepository extends JpaRepository<Manual, Integer> {
}
