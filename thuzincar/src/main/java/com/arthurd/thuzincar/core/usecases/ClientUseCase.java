package com.arthurd.thuzincar.core.usecases;

import com.arthurd.thuzincar.core.model.Client;

import java.util.List;

public interface ClientUseCase {
    Client createClient(Client client);
    List<Client> listAllClients();
    Client getClientByEmail(String email);
    Client editClientByEmail(String email , Client client);
    Client deleteClientByEmail(String email);
}
