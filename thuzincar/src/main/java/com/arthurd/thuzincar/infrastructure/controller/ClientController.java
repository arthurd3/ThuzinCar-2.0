package com.arthurd.thuzincar.infrastructure.controller;

import com.arthurd.thuzincar.core.model.Client;
import com.arthurd.thuzincar.core.usecases.ClientUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientUseCase clientUseCase;
    private final ClientDtoMapper clientDtoMapper;

    public ClientController(ClientUseCase clientUseCase, ClientDtoMapper clientDtoMapper) {
        this.clientUseCase = clientUseCase;
        this.clientDtoMapper = clientDtoMapper;
    }

    @PostMapping()
    public ResponseEntity<CreateClientResponse> createClient(@RequestBody CreateClientRequest clientRequest) {
        var clientBussinesObj = clientDtoMapper.toClient(clientRequest);
        var client = clientUseCase.createClient(clientBussinesObj);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clientDtoMapper.toResponse(client));
    }

    @GetMapping()
    public ResponseEntity<List<Client>> getAllClient() {
        var listClients = clientUseCase.listAllClients();
        return ResponseEntity.status(HttpStatus.OK)
                .body(listClients);
    }

    @GetMapping("/{email}")
    public ResponseEntity<CreateClientResponse> getClientbyEmail(@PathVariable(value = "email") String email) {
        var clientBussinesObj = clientUseCase.getClientByEmail(email);
        return ResponseEntity.status(HttpStatus.OK)
                .body(clientDtoMapper.toResponse(clientBussinesObj));
    }

    @PutMapping("/{email}")
    public ResponseEntity<CreateClientResponse> editClientByEmail(@PathVariable(value = "email") String email , @RequestBody CreateClientRequest clientRequest) {
        var clientBussinesObj = clientDtoMapper.toClient(clientRequest);
        clientBussinesObj = clientUseCase.editClientByEmail(email , clientBussinesObj);
        return ResponseEntity.status(HttpStatus.OK)
                .body(clientDtoMapper.toResponse(clientBussinesObj));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<CreateClientResponse> deleteClientByEmail(@PathVariable(value = "email") String email) {
        var deletedClient = clientUseCase.deleteClientByEmail(email);
        return ResponseEntity.status(HttpStatus.OK)
                .body(clientDtoMapper.toResponse(deletedClient));
    }

}
