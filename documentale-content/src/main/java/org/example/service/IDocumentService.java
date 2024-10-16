package org.example.service;

import org.example.persistence.entity.DocumentEntity;

import java.util.List;
import java.util.Optional;

public interface IDocumentService {

    List<DocumentEntity> getTestMessage();

    Optional<DocumentEntity> findById(Long documentId);

}