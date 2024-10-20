package org.example.service.impl;

import org.example.service.ConfigService;
import org.example.service.dtos.DocConfigDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConfigServiceClient implements ConfigService {


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public DocConfigDto getConfigByDepartment(String dep) {
        String url = "http://localhost:8080/document-config/config/"+dep;
        return restTemplate.getForObject(url,DocConfigDto.class);
    }
}
