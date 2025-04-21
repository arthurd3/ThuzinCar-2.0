package com.arthurd.thuzincar.infrastructure.car.persistence;

import com.arthurd.thuzincar.infrastructure.car.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
    CarEntity findByPlate(String plate);
}
