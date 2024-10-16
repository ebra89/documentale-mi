package org.example.client;

import org.example.config.FeignClientConfig;
import org.example.dto.DocToArchiveDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "document-archive-client", url = "http://localhost:8093", configuration = FeignClientConfig.class)
public interface DocArchiveFeignClient {
    @PostMapping(value = "/documentale-archive/archives", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> archiveDocument(@RequestBody DocToArchiveDTO dto);

}