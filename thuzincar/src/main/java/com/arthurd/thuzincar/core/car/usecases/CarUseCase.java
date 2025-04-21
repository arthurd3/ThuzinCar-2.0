package com.arthurd.thuzincar.core.car.usecases;

import com.arthurd.thuzincar.core.car.model.Car;

import java.util.List;

public interface CarUseCase {
    Car createCar(Car car);
    List<Car> getAllCars();
    Car getCarById(Long id);
}
