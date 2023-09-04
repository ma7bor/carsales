package com.garage.carsales.mapper;

import com.garage.carsales.dto.CarDto;
import com.garage.carsales.entity.Car;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface CarMapper {

    Car mapToEntity(CarDto carDTO);

    CarDto mapToDTO(Car car);

    List<Car> mapToEntityList(List<CarDto> carDtos);

    List<CarDto> mapToDTOList(List<Car> cars);
}
