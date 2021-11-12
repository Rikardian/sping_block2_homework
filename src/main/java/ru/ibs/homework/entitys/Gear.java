package ru.ibs.homework.entitys;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Gear {

    @Id
    @GeneratedValue
    private Integer id;

    private int gearSize;

    @ManyToOne
    @JoinColumn(name = "ENGINE_ID", referencedColumnName = "ID")
    private Engine engine;

    public Gear(int size) {
        this.gearSize = size;
    }

    public String toString() {
        return "Gear for engine " + engine.toString() + " with size " + getGearSize();
    }
}
