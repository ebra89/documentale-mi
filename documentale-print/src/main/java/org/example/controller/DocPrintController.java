package org.example.controller;

//import io.swagger.v3.oas.annotations.tags.Tag;

import org.example.dto.DocumentEntity;
import org.example.service.impl.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Tag(name = "TestController - TAG", description = "Descrizione - TestController - TAG")
public class DocPrintController {

    private final PrintService service;

    @Autowired
    public DocPrintController(PrintService service) {
        this.service = service;
    }

    @RequestMapping(value = "/print/{documentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    //@Tag(name = "metodo get", description = "descrizione metodo get")
    public ResponseEntity<List<DocumentEntity>> print() {
        return service.test();
    }

}
