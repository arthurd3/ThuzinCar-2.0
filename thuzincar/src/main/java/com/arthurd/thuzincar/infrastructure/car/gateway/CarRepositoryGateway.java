package com.arthurd.thuzincar.infrastructure.car.gateway;

import com.arthurd.thuzincar.core.car.gateway.CarGateway;
import com.arthurd.thuzincar.core.car.model.Car;
import com.arthurd.thuzincar.infrastructure.car.mapper.CarEntityMapper;
import com.arthurd.thuzincar.infrastructure.car.persistence.CarRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarRepositoryGateway implements CarGateway {
    private final CarRepository carRepository;
    private final CarEntityMapper carEntityMapper;
    private final CarEntityMapper createCarEntityMapper;

    public CarRepositoryGateway(CarRepository carRepository, CarEntityMapper carEntityMapper, CarEntityMapper createCarEntityMapper) {
        this.carRepository = carRepository;
        this.carEntityMapper = carEntityMapper;
        this.createCarEntityMapper = createCarEntityMapper;
    }

    @Override
    public Car createCar(Car car) {

        if(carRepository.findByPlate(car.plate()) != null)
            return null;

        var saveCar = carRepository.save(carEntityMapper.toEntity(car));
        return carEntityMapper.toModel(saveCar);
    }

    @Override
    public List<Car> getAllCars() {
        return carEntityMapper.toModelList(carRepository.findAll());
    }

    @Override
    public Car getCarById(Long id) {
        return carEntityMapper.toModel(carRepository.findById(id).orElse(null));
    }
}
