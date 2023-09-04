package com.garage.carsales.service;

import com.garage.carsales.dto.CarDto;
import com.garage.carsales.enums.FuelType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    String addCar(CarDto carDto);

    List<CarDto> getCarsByFuelTypeAndPrice(FuelType fuelType, double maxPrice);

    List<String> getCarMakes();

    String updateCarPicture(Long id, String pictureUrl);
}
