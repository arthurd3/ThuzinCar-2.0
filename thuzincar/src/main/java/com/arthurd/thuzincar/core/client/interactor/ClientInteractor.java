package com.arthurd.thuzincar.core.client.interactor;

import com.arthurd.thuzincar.core.client.gateway.ClientGateway;
import com.arthurd.thuzincar.core.client.model.Client;
import com.arthurd.thuzincar.core.client.usecases.ClientUseCase;

import java.util.List;

public class ClientInteractor implements ClientUseCase {
    private final ClientGateway clientGateway;

    public ClientInteractor(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    @Override
    public Client createClient(Client client) {
        return clientGateway.createClient(client);
    }

    @Override
    public List<Client> listAllClients() {
        return clientGateway.getAllClients();
    }

    @Override
    public Client getClientByEmail(String email) {
        if(!email.isBlank())
            return clientGateway.getClientByEmail(email);
        return null;
    }

    @Override
    public Client editClientByEmail(String email , Client client) {
        if(!email.isBlank())
            return clientGateway.editClientByEmail(email , client);
        return null;
    }

    @Override
    public Client deleteClientByEmail(String email) {
        if(!email.isBlank())
            return clientGateway.deleteClientByEmail(email);
        return null;
    }
}
