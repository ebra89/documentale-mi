package org.example.service.impl;

import org.example.dao.ContentRepository;
import org.example.dao.model.Content;
import org.example.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentRepository contentRepository;


    @Override
    public Content saveContent(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public List<Content> fetchContentList() {
        return (List<Content>) contentRepository.findAll();
    }



    @Override
    public void deleteContentById(Long id) {
        contentRepository.deleteById(id);

    }
}
