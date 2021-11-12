package ru.ibs.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.ibs.homework.repository.CarRepository;

@SpringBootApplication
public class HomeworkApplication {

    public static void main(String[] args) {

        SpringApplication.run(HomeworkApplication.class, args);

    }

}
