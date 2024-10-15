package org.example.controller;

//import io.swagger.v3.oas.annotations.tags.Tag;

import org.example.persistence.entity.DocumentEntity;
import org.example.service.impl.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Tag(name = "TestController - TAG", description = "Descrizione - TestController - TAG")
public class DocContentController {

    private final DocumentService documentService;

    @Autowired
    public DocContentController(DocumentService service) {
        this.documentService = service;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    //@Tag(name = "metodo get", description = "descrizione metodo get")
    public ResponseEntity<List<DocumentEntity>> test() {
        return new ResponseEntity<>(documentService.getTestMessage(), HttpStatus.OK);
    }

}
