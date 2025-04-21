package com.arthurd.thuzincar.core.client.gateway;

import com.arthurd.thuzincar.core.client.model.Client;

import java.util.List;

public interface ClientGateway {
    Client createClient(Client client);
    List<Client> getAllClients();
    Client getClientByEmail(String email);
    Client editClientByEmail(String email , Client client);
    Client deleteClientByEmail(String email);
}
