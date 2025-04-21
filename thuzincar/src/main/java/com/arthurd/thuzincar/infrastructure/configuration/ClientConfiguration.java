package com.arthurd.thuzincar.infrastructure.configuration;

import com.arthurd.thuzincar.core.gateway.ClientGateway;
import com.arthurd.thuzincar.core.interactor.ClientInteractor;
import com.arthurd.thuzincar.core.usecases.ClientUseCase;
import com.arthurd.thuzincar.infrastructure.controller.ClientDtoMapper;
import com.arthurd.thuzincar.infrastructure.mapper.ClientEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Criar aqui todos os Beans e injecoes de dependencias
@Configuration
public class ClientConfiguration {

    @Bean
    public ClientUseCase createClientUseCase(ClientGateway clientGateway) {
        return new ClientInteractor(clientGateway);
    }

    @Bean
    public ClientDtoMapper createClientDtoMapper() {
        return new ClientDtoMapper();
    }

    @Bean
    public ClientEntityMapper createClientEntityMapper() {
        return new ClientEntityMapper();
    }



}
