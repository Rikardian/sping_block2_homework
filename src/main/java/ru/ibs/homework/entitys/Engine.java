package ru.ibs.homework.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Engine {

    @Id
    @GeneratedValue
    private Integer id;

    String type;


    @ManyToMany(cascade = CascadeType.ALL)
    private List<Manual> manuals;

    public Engine(String engineType) {
        this.type = engineType;
        this.manuals = new LinkedList<>();
    }

    public String toString() {
        return type;
    }
}
