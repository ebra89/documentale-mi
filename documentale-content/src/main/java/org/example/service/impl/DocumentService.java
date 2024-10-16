package org.example.service.impl;

import lombok.AllArgsConstructor;
import org.example.persistence.entity.DocumentEntity;
import org.example.persistence.repo.DocumentRepository;
import org.example.service.IDocumentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DocumentService implements IDocumentService {

    private DocumentRepository documentRepository;

    @Override
    public Optional<DocumentEntity> findById(Long documentId) {
        return documentRepository.findById(documentId);
    }

    @Override
    public List<DocumentEntity> findAll() {
        return documentRepository.findAll();
    }

    @Override
    public void deleteById(Long documentId) {
        documentRepository.deleteById(documentId);
    }

    @Override
    public DocumentEntity createDocument(DocumentEntity newDoc) {
        return documentRepository.save(newDoc);
    }

    @Override
    public DocumentEntity updateDocument(DocumentEntity newDoc) {
        return documentRepository.save(newDoc);
    }

}
