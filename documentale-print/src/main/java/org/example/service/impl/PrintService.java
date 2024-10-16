package org.example.service.impl;

import org.example.client.DocContentFeignClient;
import org.example.dto.DocumentEntity;
import org.example.service.IPrintService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrintService implements IPrintService {

    private final DocContentFeignClient docContentFeignClient;

    public PrintService(DocContentFeignClient docContentFeignClient) {
        this.docContentFeignClient = docContentFeignClient;
    }

    public ResponseEntity<List<DocumentEntity>> test() {
        return docContentFeignClient.test();
    }

}
