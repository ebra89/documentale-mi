package org.example.service;

import org.example.persistence.entity.ProtocolEntity;

import java.util.List;
import java.util.Optional;

public interface IProtocolService {

    Optional<ProtocolEntity> findById(Long protocolId);

    List<ProtocolEntity> findAll();

    ProtocolEntity createProtocol(ProtocolEntity newProtocol);

    ProtocolEntity updateProtocol(ProtocolEntity newProtocol);

}