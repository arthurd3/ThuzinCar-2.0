package com.arthurd.thuzincar.core.car.gateway;

import com.arthurd.thuzincar.core.car.model.Car;

import java.util.List;

public interface CarGateway {
    Car createCar(Car car);
    List<Car> getAllCars();
    Car getCarById(Long id);
}
