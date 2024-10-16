package org.example.service;

import org.example.dto.DocumentEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPrintService {

    ResponseEntity<List<DocumentEntity>> test();

}