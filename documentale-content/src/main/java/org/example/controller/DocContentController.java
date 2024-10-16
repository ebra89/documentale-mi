package org.example.controller;

import org.example.client.DocArchiveFeignClient;
import org.example.dto.DocToArchiveDTO;
import org.example.exception.ResourceNotFoundException;
import org.example.persistence.entity.DocumentEntity;
import org.example.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
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

    //    @PreAuthorize("hasRole('ADMIN')")
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

    @GetMapping(value = "/docs")
    public ResponseEntity<List<DocumentEntity>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(documentService.findAll());
    }

    @GetMapping(value = "/docs/{documentId}")
    public ResponseEntity<DocumentEntity> findById(@PathVariable(name = "documentId") Long documentId) {
        DocumentEntity doc = documentService.findById(documentId).orElseThrow(
            () -> new ResourceNotFoundException("Document", "id", documentId != null ? String.valueOf(documentId) : null)
        );
        return ResponseEntity.status(HttpStatus.OK).body(doc);
    }

    @PutMapping(value = "/docs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DocumentEntity> updateDocument(@RequestBody DocumentEntity newDoc) {
        DocumentEntity updatedDoc = documentService.updateDocument(newDoc);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDoc);
    }

    @DeleteMapping(value = "/docs/{documentId}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "documentId") Long documentId) {
        DocumentEntity doc = documentService.findById(documentId).orElseThrow(
            () -> new ResourceNotFoundException("Document", "id", documentId != null ? String.valueOf(documentId) : null)
        );
        documentService.deleteById(doc.getId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(value = "/docs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DocumentEntity> createDocument(@RequestBody DocumentEntity newDoc) {
        DocumentEntity doc = new DocumentEntity();
        doc.setDocDate(newDoc.getDocDate());
        doc.setLocation(newDoc.getLocation());
        doc.setOwner(newDoc.getOwner());
        doc.setType(newDoc.getType());
        doc.setState(newDoc.getState());
        doc.setRefNumber(newDoc.getRefNumber());
        doc.setCreateDate(LocalDateTime.now());
        doc.setCreateUser("admin");
        DocumentEntity nDoc = documentService.createDocument(doc);
        return ResponseEntity.status(HttpStatus.OK).body(nDoc);
    }

}