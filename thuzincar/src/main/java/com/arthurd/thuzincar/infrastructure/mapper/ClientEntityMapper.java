package com.arthurd.thuzincar.infrastructure.mapper;

import com.arthurd.thuzincar.core.model.Client;
import com.arthurd.thuzincar.infrastructure.entity.ClientEntity;

public class ClientEntityMapper {
    public ClientEntity toEntity(Client clientDomainObj) {
        return new ClientEntity(null , clientDomainObj.name() , clientDomainObj.email(), clientDomainObj.phone() , clientDomainObj.userType());
    }

    public Client toDomain(ClientEntity clientEntity) {
        return new Client( clientEntity.getName() , clientEntity.getEmail() , clientEntity.getPhone());
    }
}
