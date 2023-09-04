package com.garage.carsales.service.impl;

import com.garage.carsales.dto.CarDto;
import com.garage.carsales.entity.Car;
import com.garage.carsales.enums.FuelType;
import com.garage.carsales.enums.TransmissionType;
import com.garage.carsales.exception.CarNotFoundException;
import com.garage.carsales.exception.RegistrationDateException;
import com.garage.carsales.mapper.CarMapper;
import com.garage.carsales.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CarServiceImplTest {
    @Mock
    CarRepository carRepository;
    @Mock
    CarMapper carMapper;
    @InjectMocks
    CarServiceImpl carService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Transactional
    void testAddCarSuccess() {
        Car car = new Car();
        car.setRegistrationDate(LocalDate.of(2022, 1, 1));
        String result = carService.addCar(car);
        assertEquals("Car added with success", result);
    }

    @Test
    void testUpdateCarPicture() {
        Long carId = 1L;
        String pictureUrl = "pictureUrl";
        Car existingCar = new Car(carId, "make", "model", LocalDate.of(2023, Month.SEPTEMBER, 3), 0d, FuelType.DIESEL, 0, TransmissionType.MANUAL, "picture");
        when(carRepository.findById(carId)).thenReturn(Optional.of(existingCar));
        when(carRepository.save(any(Car.class))).thenReturn(existingCar);

        String result = carService.updateCarPicture(carId, pictureUrl);

        assertEquals("Car picture has been updated with success", result);
    }

    @Test
    void testGetCarsByFuelTypeAndPrice() {
        FuelType fuelType = FuelType.DIESEL;
        double maxPrice = 0d;
        Car car = new Car(null, "make", "model", LocalDate.of(2023, Month.SEPTEMBER, 3), 0d, FuelType.DIESEL, 0, TransmissionType.MANUAL, "picture");
        when(carRepository.findByFuelTypeAndPriceLessThanEqual(fuelType, maxPrice)).thenReturn(Collections.singletonList(car));
        when(carMapper.mapToDTOList(anyList())).thenReturn(Collections.singletonList(new CarDto("make", "model", LocalDate.of(2023, Month.SEPTEMBER, 3), 0d, FuelType.DIESEL, 0, TransmissionType.MANUAL, "picture")));

        List<CarDto> result = carService.getCarsByFuelTypeAndPrice(fuelType, maxPrice);

        assertEquals(Collections.singletonList(new CarDto("make", "model", LocalDate.of(2023, Month.SEPTEMBER, 3), 0d, FuelType.DIESEL, 0, TransmissionType.MANUAL, "picture")), result);
    }

    @Test
    void testGetCarMakes() {
        when(carRepository.findDistinctMakes()).thenReturn(Collections.singletonList("String"));

        List<String> result = carService.getCarMakes();

        assertEquals(Collections.singletonList("String"), result);
    }

    @Test
    void testUpdateCarPictureCarNotFound() {
        Long carId = 1L;
        String pictureUrl = "pictureUrl";
        when(carRepository.findById(carId)).thenReturn(Optional.empty());

        assertThrows(CarNotFoundException.class, () -> {
            carService.updateCarPicture(carId, pictureUrl);
        });
    }

    @Test
    void testAddCarRegistrationDateException() {
        Car carToAdd = new Car(1L,"make", "model",
                LocalDate.of(2014, Month.DECEMBER, 31),
                0d, FuelType.DIESEL, 0, TransmissionType.MANUAL, "pictureUrl");

        assertThrows(RegistrationDateException.class, () -> {
            carService.addCar(carToAdd);
        });
    }
}