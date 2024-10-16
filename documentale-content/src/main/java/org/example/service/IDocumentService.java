package org.example.service;

import org.example.persistence.entity.DocumentEntity;

import java.util.List;
import java.util.Optional;

public interface IDocumentService {

    Optional<DocumentEntity> findById(Long documentId);

    List<DocumentEntity> findAll();

    void deleteById(Long documentId);

    DocumentEntity createDocument(DocumentEntity newDoc);

    DocumentEntity updateDocument(DocumentEntity newDoc);

}