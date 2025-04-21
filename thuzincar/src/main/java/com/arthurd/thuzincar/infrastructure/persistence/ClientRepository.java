package com.arthurd.thuzincar.infrastructure.persistence;

import com.arthurd.thuzincar.infrastructure.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
}
