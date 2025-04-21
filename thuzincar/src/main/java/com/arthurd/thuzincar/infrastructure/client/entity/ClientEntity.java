package com.arthurd.thuzincar.infrastructure.client.entity;

import com.arthurd.thuzincar.core.car.model.Car;
import com.arthurd.thuzincar.core.client.enums.UserType;
import com.arthurd.thuzincar.infrastructure.car.entity.CarEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "CLIENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<CarEntity> cars;


}


