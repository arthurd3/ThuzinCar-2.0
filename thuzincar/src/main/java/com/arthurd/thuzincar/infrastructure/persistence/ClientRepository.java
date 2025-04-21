package com.arthurd.thuzincar.infrastructure.persistence;

import com.arthurd.thuzincar.infrastructure.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
    List<ClientEntity> findAll();
    ClientEntity findByEmail(String email);

}
