package org.example.controller;

//import io.swagger.v3.oas.annotations.tags.Tag;

import org.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Tag(name = "TestController - TAG", description = "Descrizione - TestController - TAG")
public class DocArchiveController {

    private final TestService service;

    @Autowired
    public DocArchiveController(TestService service) {
        this.service = service;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    //@Tag(name = "metodo get", description = "descrizione metodo get")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>(service.getTestMessage(), HttpStatus.OK);
    }

}
