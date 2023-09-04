package com.garage.carsales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.garage.carsales.service")
@ComponentScan(basePackages = "com.garage.carsales")
public class CarsalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarsalesApplication.class, args);
    }

}
