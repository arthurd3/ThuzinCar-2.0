package com.arthurd.thuzincar.infrastructure.controller;

import com.arthurd.thuzincar.core.usecases.ClientUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientUseCase clientUseCase;
    private final ClientDtoMapper clientDtoMapper;

    public ClientController(ClientUseCase clientUseCase, ClientDtoMapper clientDtoMapper) {
        this.clientUseCase = clientUseCase;
        this.clientDtoMapper = clientDtoMapper;
    }

    public ResponseEntity<CreateClientResponse> createClient(@RequestBody CreateClientRequest clientRequest) {
        var clientBussinesObj = clientDtoMapper.toClient(clientRequest);
        var client = clientUseCase.createClient(clientBussinesObj);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clientDtoMapper.toResponse(client));
    }

}
