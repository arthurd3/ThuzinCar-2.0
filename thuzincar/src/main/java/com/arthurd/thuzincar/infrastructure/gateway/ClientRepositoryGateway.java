package com.arthurd.thuzincar.infrastructure.gateway;


import com.arthurd.thuzincar.core.gateway.ClientGateway;
import com.arthurd.thuzincar.core.model.Client;
import com.arthurd.thuzincar.infrastructure.entity.ClientEntity;
import com.arthurd.thuzincar.infrastructure.mapper.ClientEntityMapper;
import com.arthurd.thuzincar.infrastructure.persistence.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Client getClientByEmail(String email) {
        return clientEntityMapper.toDomain
                (clientRepository.findByEmail(email));
    }

    @Override
    public Client editClientByEmail(String email , Client client) {
        var originalClient = clientRepository.findByEmail(email);

        if(originalClient != null){

            originalClient.setName(client.name());
            originalClient.setEmail(client.email());
            originalClient.setPhone(client.phone());

            var updatedClient = clientRepository.save(originalClient);

            return clientEntityMapper.toDomain(updatedClient);
        }
        return null;

    }
    @Transactional
    @Override
    public Client deleteClientByEmail(String email) {
        var originalClient = clientRepository.findByEmail(email);
        if(originalClient != null){
            clientRepository.delete(originalClient);
            return clientEntityMapper.toDomain(originalClient);
        }
        return null;
    }
}
