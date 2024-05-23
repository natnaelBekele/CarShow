package com.binary.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="car_table")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand,model,color,registationNumber;
    private int year;
    @Column(name = "car_price")
    private double price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ownerId")
    @JsonIgnore
    private Owner owner;

    public Car(double price, int year, String registationNumber, String color, String model, String brand,Owner owner) {
        this.price = price;
        this.year = year;
        this.registationNumber = registationNumber;
        this.color = color;
        this.model = model;
        this.brand = brand;
    }

    public Car() {

    }

}
