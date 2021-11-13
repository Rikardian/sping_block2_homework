package ru.ibs.homework.entitys;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Manual {

    @Id
    @GeneratedValue
    private Integer id;

    String type;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "manuals")
    List<Engine> engines;

    public Manual(String type) {
        this.type  = type;
        this.engines = new LinkedList<>();
    }

    public String toString() {
        return "Мануал " + type;
    }
}
