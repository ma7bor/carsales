package com.garage.carsales.dto;

import com.garage.carsales.enums.FuelType;
import com.garage.carsales.enums.TransmissionType;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CarDto implements Serializable {
    private String make;
    private String model;
    private LocalDate registrationDate;
    private double price;
    private FuelType fuelType;
    private int mileage;
    private TransmissionType transmission;
    private String picture;
}
