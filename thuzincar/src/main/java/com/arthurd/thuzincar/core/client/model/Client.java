package com.arthurd.thuzincar.core.client.model;

import com.arthurd.thuzincar.core.car.model.Car;
import com.arthurd.thuzincar.core.client.enums.UserType;

import java.util.List;

public record Client (String name, String email, String phone , List<Car> cars) {
    public UserType userType() {
        return UserType.CLIENT;
    }


}
