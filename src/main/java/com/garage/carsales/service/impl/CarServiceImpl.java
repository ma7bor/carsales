package com.garage.carsales.service.impl;

import com.garage.carsales.dto.CarDto;
import com.garage.carsales.entity.Car;
import com.garage.carsales.enums.FuelType;
import com.garage.carsales.exception.CarNotFoundException;
import com.garage.carsales.exception.RegistrationDateException;
import com.garage.carsales.mapper.CarMapper;
import com.garage.carsales.repository.CarRepository;
import com.garage.carsales.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    @Transactional
    public String addCar(CarDto carDto) {
        if (carDto.getRegistrationDate().isAfter(LocalDate.of(2015, 12, 31))) {
            carRepository.save(carMapper.mapToEntity(carDto));
            return "Car added with success";
        } else {
            throw new RegistrationDateException("Only car registered after 2015 are allowed to be add to the catalog");
        }
    }

    @Override
    public String updateCarPicture(Long id, String pictureUrl) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setPicture(pictureUrl);
            carRepository.save(car);
            return "Car picture has been updated with success";
        }
        throw new CarNotFoundException("Car with ID " + id + " not found");
    }

    @Override
    public List<CarDto> getCarsByFuelTypeAndPrice(FuelType fuelType, double maxPrice) {
        return carMapper.mapToDTOList(carRepository.findByFuelTypeAndPriceLessThanEqual(fuelType, maxPrice));
    }

    @Override
    public List<String> getCarMakes() {
        return carRepository.findDistinctMakes();
    }
}



