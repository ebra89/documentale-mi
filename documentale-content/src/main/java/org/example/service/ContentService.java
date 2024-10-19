package org.example.service;

import org.example.dao.model.Content;

import java.util.List;

public interface ContentService {
    Content saveContent(Content content);

    List<Content> fetchContentList();


    void deleteContentById(Long id);



}
