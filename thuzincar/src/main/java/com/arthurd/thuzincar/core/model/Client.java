package com.arthurd.thuzincar.core.model;

import com.arthurd.thuzincar.core.enums.UserType;

public record Client (String name, String email, String phone, UserType userType) {
}
