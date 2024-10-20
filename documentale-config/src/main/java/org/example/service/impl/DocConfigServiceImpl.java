package org.example.service.impl;

import org.example.dao.DocConfigRepository;
import org.example.dao.model.DocConfig;
import org.example.dao.model.DocUser;
import org.example.service.DocConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocConfigServiceImpl implements DocConfigService {

    @Autowired
    private DocConfigRepository docConfigRepository;
    @Override
    public DocConfig saveConfig(DocConfig config) {
        return docConfigRepository.save(config);
    }

    @Override
    public List<DocConfig> fetchConfigList() {
        return (List<DocConfig>)docConfigRepository.findAll();
    }

    @Override
    public void deleteConfigById(Long id) {
        docConfigRepository.deleteById(id);
    }

    @Override
    public DocConfig fetchConfigByDepartment(String department) {
        return docConfigRepository.findByDepartment(department);
    }
}
