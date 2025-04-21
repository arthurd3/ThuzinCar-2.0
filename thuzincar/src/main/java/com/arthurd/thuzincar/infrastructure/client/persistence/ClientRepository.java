package com.arthurd.thuzincar.infrastructure.client.persistence;

import com.arthurd.thuzincar.infrastructure.client.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    List<ClientEntity> findAll();
    ClientEntity findByEmail(String email);

}
