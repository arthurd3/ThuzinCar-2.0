package com.arthurd.thuzincar.infrastructure.car.controller;

import com.arthurd.thuzincar.core.car.model.Car;
import com.arthurd.thuzincar.core.car.usecases.CarUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarDtoMapper carDtoMapper;
    private final CarUseCase carUseCase;

    public CarController(CarDtoMapper carDtoMapper, CarUseCase carUseCase) {
        this.carDtoMapper = carDtoMapper;
        this.carUseCase = carUseCase;
    }

    @PostMapping()
    public ResponseEntity<CreateCarResponse> createCar(@RequestBody CreateCarRequest carRequest){
        var carBussinesObj = carDtoMapper.toClient(carRequest);
        var createdCar = carUseCase.createCar(carBussinesObj);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(carDtoMapper.toResponse(createdCar));

    }

}
