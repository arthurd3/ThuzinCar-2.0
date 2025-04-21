package com.arthurd.thuzincar.infrastructure.controller;

import com.arthurd.thuzincar.core.model.Client;

public class ClientDtoMapper {
    public Client toClient(CreateClientRequest clientRequest) {
        return new Client(clientRequest.name(), clientRequest.email(), clientRequest.phone());
    }

    public CreateClientResponse toResponse(Client client) {
        return new CreateClientResponse(client.name() ,client.email() , client.phone(), client.userType());
    }
}
