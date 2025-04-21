package com.arthurd.thuzincar.core.interactor;

import com.arthurd.thuzincar.core.gateway.ClientGateway;
import com.arthurd.thuzincar.core.model.Client;
import com.arthurd.thuzincar.core.usecases.ClientUseCase;

public class ClientInteractor implements ClientUseCase {
    private final ClientGateway clientGateway;

    public ClientInteractor(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    @Override
    public Client createClient(Client client) {
        return clientGateway.createClient(client);
    }
}
