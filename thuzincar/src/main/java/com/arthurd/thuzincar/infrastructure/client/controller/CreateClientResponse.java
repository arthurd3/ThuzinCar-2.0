package com.arthurd.thuzincar.infrastructure.client.controller;
import com.arthurd.thuzincar.core.client.enums.UserType;

public record CreateClientResponse(String name , String email, String phone , UserType userType) {
}
