package com.arthurd.thuzincar.infrastructure.mapper;

import com.arthurd.thuzincar.core.model.Client;
import com.arthurd.thuzincar.infrastructure.controller.CreateClientRequest;
import com.arthurd.thuzincar.infrastructure.controller.CreateClientResponse;

public class ClientEntityMapper {
    public Client toUser(CreateClientRequest clientRequest) {
        return new Client(clientRequest.name(), clientRequest.email(), clientRequest.phone(), clientRequest.userType());
    }

    public CreateClientResponse toResponse(Client client) {
        return new CreateClientResponse(client.name() ,client.email() , client.phone(), client.userType());
    }
}
