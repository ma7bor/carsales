package com.garage.carsales.controller;

import com.garage.carsales.dto.CarDto;
import com.garage.carsales.entity.Car;
import com.garage.carsales.enums.FuelType;
import com.garage.carsales.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<String> addCar(@RequestBody Car car) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.addCar(car));
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getCarsByFuelAndPrice(@RequestParam FuelType fuelType,
                                                              @RequestParam double maxPrice) {
        return ResponseEntity.status(HttpStatus.OK).body(
                carService.getCarsByFuelTypeAndPrice(fuelType, maxPrice));
    }

    @GetMapping("/make")
    public ResponseEntity<List<String>> getAllMakes() {
        return ResponseEntity.status(HttpStatus.OK).body(
                carService.getCarMakes());
    }

    @PutMapping("/{id}/picture")
    public ResponseEntity<String> updateCarPicture(@PathVariable Long id, @RequestParam String pictureUrl) {
        return ResponseEntity.status(HttpStatus.OK).body(
                carService.updateCarPicture(id, pictureUrl));
    }
}
