package org.example.service;

import org.example.dto.DocumentEntity;
import org.springframework.http.ResponseEntity;

public interface IPrintService {

    ResponseEntity<DocumentEntity> fetchDocumentById(Long documentId);

}