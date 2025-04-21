package com.arthurd.thuzincar.core.car.interactor;

import com.arthurd.thuzincar.core.car.gateway.CarGateway;
import com.arthurd.thuzincar.core.car.model.Car;
import com.arthurd.thuzincar.core.car.usecases.CarUseCase;

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
}
