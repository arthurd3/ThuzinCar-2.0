package com.arthurd.thuzincar.infrastructure.car.gateway;

import com.arthurd.thuzincar.core.car.gateway.CarGateway;
import com.arthurd.thuzincar.core.car.model.Car;
import com.arthurd.thuzincar.infrastructure.car.mapper.CarEntityMapper;
import com.arthurd.thuzincar.infrastructure.car.persistence.CarRepository;
import org.springframework.stereotype.Component;

@Component
public class CarRepositoryGateway implements CarGateway {
    private final CarRepository carRepository;
    private final CarEntityMapper carEntityMapper;

    public CarRepositoryGateway(CarRepository carRepository, CarEntityMapper carEntityMapper) {
        this.carRepository = carRepository;
        this.carEntityMapper = carEntityMapper;
    }

    @Override
    public Car createCar(Car car) {
        var saveCar = carRepository.save(carEntityMapper.toEntity(car));
        return carEntityMapper.toModel(saveCar);
    }
}
