package org.example.service;

import org.example.service.dtos.DocConfigDto;



public interface ConfigService {

    DocConfigDto getConfigByDepartment(String dep);

}
