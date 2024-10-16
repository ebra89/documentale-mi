package org.example.controller;

import org.example.dto.DocumentEntity;
import org.example.exception.ResourceNotFoundException;
import org.example.service.impl.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DocPrintController {

    private final PrintService printSservice;

    @Autowired
    public DocPrintController(PrintService service) {
        this.printSservice = service;
    }

    @GetMapping(value = "/print/{documentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> printDocument(@PathVariable(name = "documentId") Long documentId) {
        DocumentEntity doc = Optional.ofNullable(printSservice.fetchDocumentById(documentId)).orElseThrow(
            () -> new ResourceNotFoundException("Document", "id", documentId != null ? String.valueOf(documentId) : null)
        ).getBody();
        return ResponseEntity.status(HttpStatus.OK).body("Document " + doc.getRefNumber() + " has been printed");
    }

    @GetMapping(value = "/print-status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> printStatus() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(Math.random() < 0.5 ? "Printing" : Math.random() < 0.2 ? "All printer busy" : "Printer ready");
    }

}
