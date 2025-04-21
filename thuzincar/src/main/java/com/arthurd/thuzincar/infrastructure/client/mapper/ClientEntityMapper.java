package com.arthurd.thuzincar.infrastructure.client.mapper;

import com.arthurd.thuzincar.core.client.model.Client;
import com.arthurd.thuzincar.infrastructure.car.mapper.CarEntityMapper;
import com.arthurd.thuzincar.infrastructure.client.entity.ClientEntity;

public class ClientEntityMapper {
    private final CarEntityMapper carEntityMapper;

    public ClientEntityMapper(CarEntityMapper carEntityMapper) {
        this.carEntityMapper = carEntityMapper;
    }

    public ClientEntity toEntity(Client clientDomainObj) {

        return new ClientEntity(null ,
                clientDomainObj.name() ,
                clientDomainObj.email(),
                clientDomainObj.phone() ,
                clientDomainObj.userType() ,
                carEntityMapper.toEntityList(clientDomainObj.cars()));
    }

    public Client toDomain(ClientEntity clientEntity) {
        return new Client(clientEntity.getName() ,
                clientEntity.getEmail() ,
                clientEntity.getPhone() ,
                carEntityMapper.toModelList(clientEntity.getCars()));
    }
}
