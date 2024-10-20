package org.example.service;

import org.example.dao.model.DocConfig;


import java.util.List;

public interface DocConfigService {

    DocConfig saveConfig(DocConfig config);

    List<DocConfig> fetchConfigList();


    void deleteConfigById(Long id);

    DocConfig fetchConfigByDepartment(String department);
}
