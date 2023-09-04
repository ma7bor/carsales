package com.garage.carsales.entity;

import com.garage.carsales.enums.FuelType;
import com.garage.carsales.enums.TransmissionType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;

    private String model;

    private LocalDate registrationDate;

    private double price;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private int mileage;

    @Enumerated(EnumType.STRING)
    private TransmissionType transmission;

    private String picture;
}