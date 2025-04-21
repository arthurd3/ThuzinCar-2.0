package com.arthurd.thuzincar.infrastructure.car.entity;

import com.arthurd.thuzincar.infrastructure.client.entity.ClientEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CAR")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long car_id;
    @Column(name = "car_model")
    private String model;
    @Column(name = "car_year")
    private String year;
    @Column(name = "car_plate" , unique = true)
    private String plate;
    @Column(name = "car_color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

//
//    @ManyToOne
//    @JoinColumn(name = "mechanic_id")
//    private List<MechenicEntity> mechenics;

}
