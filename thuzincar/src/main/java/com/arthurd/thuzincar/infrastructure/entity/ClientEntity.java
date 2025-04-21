package com.arthurd.thuzincar.infrastructure.entity;

import com.arthurd.thuzincar.core.enums.UserType;
import jakarta.persistence.*;
@Entity
@Table(name = "CLIENT")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name ;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}


