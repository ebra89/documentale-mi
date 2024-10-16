package org.example.controller;

//import io.swagger.v3.oas.annotations.tags.Tag;

import org.example.dto.DocumentEntity;
import org.example.service.impl.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DocPrintController {

    private final PrintService service;

    @Autowired
    public DocPrintController(PrintService service) {
        this.service = service;
    }

    @RequestMapping(value = "/print/{documentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DocumentEntity>> print() {
        return service.test();
    }

    @GetMapping(value = "/print-status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> printStatus() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(Math.random() < 0.5 ? "Printing" : Math.random() < 0.2 ? "All printer busy" : "Printer ready");
    }

}
