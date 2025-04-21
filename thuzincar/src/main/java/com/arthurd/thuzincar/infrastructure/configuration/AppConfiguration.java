package com.arthurd.thuzincar.infrastructure.configuration;

import com.arthurd.thuzincar.core.car.gateway.CarGateway;
import com.arthurd.thuzincar.core.car.interactor.CarInteractor;
import com.arthurd.thuzincar.core.car.usecases.CarUseCase;
import com.arthurd.thuzincar.core.client.gateway.ClientGateway;
import com.arthurd.thuzincar.core.client.interactor.ClientInteractor;
import com.arthurd.thuzincar.core.client.usecases.ClientUseCase;
import com.arthurd.thuzincar.infrastructure.car.controller.CarDtoMapper;
import com.arthurd.thuzincar.infrastructure.car.mapper.CarEntityMapper;
import com.arthurd.thuzincar.infrastructure.client.controller.ClientDtoMapper;
import com.arthurd.thuzincar.infrastructure.client.mapper.ClientEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Criar aqui todos os Beans e injecoes de dependencias
@Configuration
public class AppConfiguration {

    @Bean
    public ClientUseCase createClientUseCase(ClientGateway clientGateway) {
        return new ClientInteractor(clientGateway);
    }

    @Bean
    public ClientDtoMapper createClientDtoMapper() {
        return new ClientDtoMapper();
    }

    @Bean
    public ClientEntityMapper createClientEntityMapper(CarEntityMapper carEntityMapper) {
        return new ClientEntityMapper(carEntityMapper);
    }

    @Bean
    public CarUseCase createCarUseCase(CarGateway carGateway) {
        return new CarInteractor(carGateway);
    }


    @Bean
    CarEntityMapper createCarEntityMapper() {
        return new CarEntityMapper();
    }

    @Bean
    CarDtoMapper createCarDtoMapper() {
        return new CarDtoMapper();
    }


}
