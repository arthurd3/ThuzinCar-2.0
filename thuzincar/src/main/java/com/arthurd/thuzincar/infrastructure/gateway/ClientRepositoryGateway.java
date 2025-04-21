package com.arthurd.thuzincar.infrastructure.gateway;


import com.arthurd.thuzincar.core.gateway.ClientGateway;
import com.arthurd.thuzincar.core.model.Client;
import com.arthurd.thuzincar.infrastructure.mapper.ClientEntityMapper;
import com.arthurd.thuzincar.infrastructure.persistence.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class ClientRepositoryGateway implements ClientGateway {
    private final ClientRepository clientRepository;
    private final ClientEntityMapper clientEntityMapper;

    public ClientRepositoryGateway(ClientRepository clientRepository, ClientEntityMapper clientEntityMapper) {
        this.clientRepository = clientRepository;
        this.clientEntityMapper = clientEntityMapper;
    }


    @Override
    public Client createClient(Client clientDomainObj) {
        var clientEntity = clientEntityMapper.toEntity(clientDomainObj);
        var savedClient = clientRepository.save(clientEntity);
        return clientEntityMapper.toDomain(savedClient);
    }
}
