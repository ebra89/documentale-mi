package org.example.controller;

//import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.example.dto.DocToArchiveDTO;
import org.example.persistence.entity.ArchiveEntity;
import org.example.service.impl.ArchiveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DocArchiveController {

    private final ArchiveService archiveService;

    public DocArchiveController(ArchiveService archiveService) {
        this.archiveService = archiveService;
    }

    @PostMapping(value = "/archives", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> archiveDocument(@Valid @RequestBody DocToArchiveDTO dto) {
        archiveService.saveDocument(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/archives", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArchiveEntity>> archiveDocument() {
        List<ArchiveEntity> archives = archiveService.findAll();
        return ResponseEntity.ofNullable(archives);
    }

}
