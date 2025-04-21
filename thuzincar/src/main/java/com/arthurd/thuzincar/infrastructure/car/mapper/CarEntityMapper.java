package com.arthurd.thuzincar.infrastructure.car.mapper;

import com.arthurd.thuzincar.core.car.model.Car;
import com.arthurd.thuzincar.infrastructure.car.entity.CarEntity;

import java.util.List;

public class CarEntityMapper {
    public static CarEntity toEntity(Car car) {
        CarEntity entity = new CarEntity();
        entity.setModel(car.model());
        entity.setYear(car.year());
        entity.setPlate(car.plate());
        entity.setColor(car.color());
        entity.setClient(null);
        entity.setCar_id(null);
        return entity;
    }

    public static Car toModel(CarEntity entity) {
        return new Car(entity.getModel() , entity.getYear() , entity.getPlate() , entity.getColor());
    }

    public static List<CarEntity> toEntityList(List<Car> cars) {
        if(cars == null) return null;
        return cars.stream().map(CarEntityMapper::toEntity).toList();
    }

    public static List<Car> toModelList(List<CarEntity> entities) {
        if(entities == null) return null;
        return entities.stream().map(CarEntityMapper::toModel).toList();
    }
}
