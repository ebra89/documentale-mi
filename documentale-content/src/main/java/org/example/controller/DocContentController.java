package org.example.controller;

import org.example.client.DocArchiveFeignClient;
import org.example.dto.DocToArchiveDTO;
import org.example.exception.ResourceNotFoundException;
import org.example.persistence.entity.DocumentEntity;
import org.example.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DocContentController {

    private final IDocumentService documentService;
    private final DocArchiveFeignClient docArchiveFeignClient;

    @Autowired
    public DocContentController(
        DocArchiveFeignClient docArchiveFeignClient,
        IDocumentService documentService
    ) {
        this.docArchiveFeignClient = docArchiveFeignClient;
        this.documentService = documentService;
    }

    @PostMapping(value = "/docs/{documentId}/archive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> archiveDocument(@PathVariable(name = "documentId") Long documentId) {
        Optional<DocumentEntity> document = Optional.ofNullable(documentService.findById(documentId).orElseThrow(
            () -> new ResourceNotFoundException("Document", "id", documentId != null ? String.valueOf(documentId) : null)
        ));
        DocumentEntity doc = document.get();
        DocToArchiveDTO dto = new DocToArchiveDTO();
        dto.setDocumentId(doc.getId());
        dto.setArchiveUserId("luca.verdi@doc.it");
        return docArchiveFeignClient.archiveDocument(dto);
    }

}