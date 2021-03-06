package ru.ibs.homework.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue
    private Integer id;


    private String mnfName;


    private String modelName;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Engine engine;

    @JsonIgnore
    @JoinColumn(name = "WHEEL_ID")
    @OneToOne(cascade = CascadeType.ALL)
    private SteeringWheel steeringWheel;

    public Car(String manufacturerName, String modelName) {
        this.mnfName = manufacturerName;
        this.modelName = modelName;
    }

    public String toString() {
        return String.join(" ", mnfName, modelName);
    }

}
