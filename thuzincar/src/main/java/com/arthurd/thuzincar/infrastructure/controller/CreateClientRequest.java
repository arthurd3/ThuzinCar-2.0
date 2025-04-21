package com.arthurd.thuzincar.infrastructure.controller;

import com.arthurd.thuzincar.core.enums.UserType;

public record CreateClientRequest (String name, String email, String phone){

}
