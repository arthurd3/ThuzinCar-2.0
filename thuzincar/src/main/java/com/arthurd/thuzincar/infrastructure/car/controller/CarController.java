package com.arthurd.thuzincar.infrastructure.car.controller;

import com.arthurd.thuzincar.core.car.usecases.CarUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public ResponseEntity<List<CreateCarResponse>> getAllCars(){
        var carList = carUseCase.getAllCars();
        var carResponseList = carDtoMapper.toResponseList(carList);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(carResponseList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateCarResponse> getCarById(@PathVariable(value = "id") Long id){
        var car = carUseCase.getCarById(id);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(carDtoMapper.toResponse(car));

    }


}
