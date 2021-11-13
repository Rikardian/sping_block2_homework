package ru.ibs.homework.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class SteeringWheel {

    @Id
    @GeneratedValue
    private Integer id;

    private String type;

    public SteeringWheel(String type) {
        this.type = type;
    }

    public String toString() {
        return "Руль " +type;
    }
}
