package org.example.service.impl;

import lombok.AllArgsConstructor;
import org.example.persistence.entity.ProtocolEntity;
import org.example.persistence.repo.ProtocolRepository;
import org.example.service.IProtocolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProtocolService implements IProtocolService {

    private ProtocolRepository protocolRepository;

    @Override
    public Optional<ProtocolEntity> findById(Long protocolId) {
        return protocolRepository.findById(protocolId);
    }

    @Override
    public List<ProtocolEntity> findAll() {
        return protocolRepository.findAll();
    }

    @Override
    public ProtocolEntity createProtocol(ProtocolEntity newProtocol) {
        return protocolRepository.save(newProtocol);
    }

    @Override
    public ProtocolEntity updateProtocol(ProtocolEntity newProtocol) {
        return protocolRepository.save(newProtocol);
    }

}