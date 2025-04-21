package com.arthurd.thuzincar.core.car.interactor;

import com.arthurd.thuzincar.core.car.gateway.CarGateway;
import com.arthurd.thuzincar.core.car.model.Car;
import com.arthurd.thuzincar.core.car.usecases.CarUseCase;

import java.util.List;

public class CarInteractor implements CarUseCase {
    private final CarGateway carGateway;

    public CarInteractor(CarGateway carGateway) {
        this.carGateway = carGateway;
    }

    @Override
    public Car createCar(Car car) {
        if(car == null) return null;
        return carGateway.createCar(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carGateway.getAllCars();
    }

    @Override
    public Car getCarById(Long id) {
        return carGateway.getCarById(id);
    }
}
