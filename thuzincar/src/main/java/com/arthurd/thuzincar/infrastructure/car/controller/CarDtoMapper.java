package com.arthurd.thuzincar.infrastructure.car.controller;

import com.arthurd.thuzincar.core.car.model.Car;
import com.arthurd.thuzincar.core.client.model.Client;
import com.arthurd.thuzincar.infrastructure.client.controller.CreateClientResponse;

public class CarDtoMapper {
    public Car toClient(CreateCarRequest carRequest) {
        return new Car(carRequest.model() , carRequest.year() , carRequest.plate() , carRequest.color());
    }

    public CreateCarResponse toResponse(Car car) {
        return new CreateCarResponse(car.model() , car.year() , car.plate() , car.color());
    }
}
