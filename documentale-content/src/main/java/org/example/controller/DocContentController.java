package org.example.controller;

//import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.dao.model.Content;
import org.example.service.ContentService;
import org.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Tag(name = "TestController - TAG", description = "Descrizione - TestController - TAG")
public class DocContentController {

    private final TestService service;

    @Autowired
    private ContentService contentService;

    @Autowired
    public DocContentController(TestService service) {
        this.service = service;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    //@Tag(name = "metodo get", description = "descrizione metodo get")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("I'm ok!, from Content", HttpStatus.OK);
    }

    // Save operation
    @PostMapping("/content")
    public Content saveContent(@Valid @RequestBody Content content)
    {
        return contentService.saveContent(content);
    }

    // Read operation
    @GetMapping("/contents")
    public List<Content> fetchContentList()
    {
        return contentService.fetchContentList();
    }

    // Update operation
   /* @PutMapping("/departments/{id}")
    public Content updateDepartment(@RequestBody Content department,
                     @PathVariable("id") Long departmentId)
    {
        return contentService.updateDepartment(
                department, departmentId);
    }*/

    // Delete operation
    @DeleteMapping("/content/{id}")
    public String deleteContentById(@PathVariable("id") Long id)
    {
        contentService.deleteContentById(id);
        return "Deleted Successfully";
    }

}
