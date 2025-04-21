package com.arthurd.thuzincar.infrastructure.client.controller;

import com.arthurd.thuzincar.core.client.model.Client;

public class ClientDtoMapper {
    public Client toClient(CreateClientRequest clientRequest) {
        return new Client(clientRequest.name(), clientRequest.email(), clientRequest.phone() , null);
    }

    public CreateClientResponse toResponse(Client client) {
        return new CreateClientResponse(client.name() ,client.email() , client.phone(), client.userType());
    }

}
