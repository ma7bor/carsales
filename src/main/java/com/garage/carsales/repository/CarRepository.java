package com.garage.carsales.repository;

import com.garage.carsales.entity.Car;
import com.garage.carsales.enums.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByFuelTypeAndPriceLessThanEqual(FuelType fuelType, double maxPrice);

    @Query("SELECT DISTINCT c.make FROM Car c")
    List<String> findDistinctMakes();
}
