package org.example.controller;

//import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.dao.model.DocConfig;
import org.example.dao.model.DocUser;
import org.example.service.DocConfigService;
import org.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Tag(name = "TestController - TAG", description = "Descrizione - TestController - TAG")
public class DocConfController {

    private final TestService service;

    @Autowired
    private DocConfigService docConfigService;



    @Autowired
    public DocConfController(TestService service) {
        this.service = service;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    //@Tag(name = "metodo get", description = "descrizione metodo get")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("I'm ok, from Config", HttpStatus.OK);
    }

    @PostMapping("/config")
    public DocConfig saveConfig(@Valid @RequestBody DocConfig config)
    {
        return docConfigService.saveConfig(config);
    }

    // Read operation
    @GetMapping("/configs")
    public List<DocConfig> fetchConfigList()
    {
        return docConfigService.fetchConfigList();
    }

    @GetMapping("/config/{department}")
    public DocConfig fetchConfigByDepartment(@PathVariable("department") String department)
    {
        return docConfigService.fetchConfigByDepartment(department);
    }


    // Delete operation
    @DeleteMapping("/config/{id}")
    public String deleteConfigById(@PathVariable("id") Long id)
    {
        docConfigService.deleteConfigById(id);
        return "Deleted Successfully";
    }
}
