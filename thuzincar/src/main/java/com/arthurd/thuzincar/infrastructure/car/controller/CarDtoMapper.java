package com.arthurd.thuzincar.infrastructure.car.controller;

import com.arthurd.thuzincar.core.car.model.Car;
import com.arthurd.thuzincar.core.client.model.Client;
import com.arthurd.thuzincar.infrastructure.car.entity.CarEntity;
import com.arthurd.thuzincar.infrastructure.car.mapper.CarEntityMapper;
import com.arthurd.thuzincar.infrastructure.client.controller.CreateClientResponse;

import java.util.List;

public class CarDtoMapper {
    public static Car toClient(CreateCarRequest carRequest) {
        return new Car(carRequest.model() , carRequest.year() , carRequest.plate() , carRequest.color());
    }

    public static CreateCarResponse toResponse(Car car) {
        return new CreateCarResponse(car.model() , car.year() , car.plate() , car.color());
    }


    public static List<CreateCarResponse> toResponseList(List<Car> entities) {
        if(entities == null) return null;
        return entities.stream().map(CarDtoMapper::toResponse).toList();
    }
}
