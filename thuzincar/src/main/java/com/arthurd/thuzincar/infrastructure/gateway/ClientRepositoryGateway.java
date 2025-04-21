package com.arthurd.thuzincar.infrastructure.gateway;


import com.arthurd.thuzincar.core.gateway.ClientGateway;
import com.arthurd.thuzincar.core.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientRepositoryGateway implements ClientGateway {

    @Override
    public Client createClient(Client clientDomainObj) {
        return clientDomainObj;
    }
}
