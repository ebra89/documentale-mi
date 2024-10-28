package org.example.controller;

import org.example.exception.ResourceNotFoundException;
import org.example.persistence.entity.ProtocolEntity;
import org.example.service.IProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class DocProtocolController {

    private final IProtocolService protocolService;

    @Autowired
    public DocProtocolController(
        IProtocolService protocolService
    ) {
        this.protocolService = protocolService;
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/protocols")
    public ResponseEntity<List<ProtocolEntity>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(protocolService.findAll());
    }

    @GetMapping(value = "/protocols/{protocolId}")
    public ResponseEntity<ProtocolEntity> findById(@PathVariable(name = "protocolId") Long protocolId) {
        ProtocolEntity protocol = protocolService.findById(protocolId).orElseThrow(
            () -> new ResourceNotFoundException("Protocol", "id", protocolId != null ? String.valueOf(protocolId) : null)
        );
        return ResponseEntity.status(HttpStatus.OK).body(protocol);
    }

    @PutMapping(value = "/protocols", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProtocolEntity> updateProtocol(@RequestBody ProtocolEntity newProtocol) {
        ProtocolEntity updatedProtocol = protocolService.updateProtocol(newProtocol);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProtocol);
    }

    @PostMapping(value = "/protocols", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProtocolEntity> createProtocol(@RequestBody ProtocolEntity newProtocol) {
        ProtocolEntity protocol = new ProtocolEntity();
        protocol.setType(newProtocol.getType());
        protocol.setState(newProtocol.getState());
        protocol.setCreateDate(LocalDateTime.now());
        protocol.setCreateUser("admin");
        protocol.setIsValid(false);
        protocol.setValidationUser(null);
        ProtocolEntity nProtocol = protocolService.createProtocol(protocol);
        return ResponseEntity.status(HttpStatus.OK).body(nProtocol);
    }

}