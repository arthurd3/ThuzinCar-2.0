package com.arthurd.thuzincar.infrastructure.controller;

import com.arthurd.thuzincar.core.model.Client;
import com.arthurd.thuzincar.core.usecases.ClientUseCase;
import com.arthurd.thuzincar.infrastructure.mapper.ClientEntityMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientUseCase clientUseCase;
    private final ClientEntityMapper clientEntityMapper;

    public ClientController(ClientUseCase clientUseCase, ClientEntityMapper clientEntityMapper) {
        this.clientUseCase = clientUseCase;
        this.clientEntityMapper = clientEntityMapper;
    }

    public ResponseEntity<CreateClientResponse> createClient(@RequestBody CreateClientRequest clientRequest) {
        var clientBussinesObj = clientEntityMapper.toUser(clientRequest);
        var client = clientUseCase.createClient(clientBussinesObj);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clientEntityMapper.toResponse(client));
    }

}
