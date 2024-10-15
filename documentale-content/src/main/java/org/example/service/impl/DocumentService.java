package org.example.service.impl;

import lombok.AllArgsConstructor;
import org.example.persistence.entity.DocumentEntity;
import org.example.persistence.repo.DocumentRepository;
import org.example.service.IDocumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DocumentService implements IDocumentService {

    private DocumentRepository documentRepository;

    @Override
    public List<DocumentEntity> getTestMessage() {
        return documentRepository.findAll();
    }

}
