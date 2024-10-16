package org.example.client;

import org.example.config.FeignClientConfig;
import org.example.dto.DocumentEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "document-content-client", url = "http://localhost:8092", configuration = FeignClientConfig.class)
public interface DocContentFeignClient {
    @GetMapping(value = "/documentale-content/docs/{documentId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DocumentEntity> fetchDocumentById(@PathVariable(name = "documentId") Long documentId);

}