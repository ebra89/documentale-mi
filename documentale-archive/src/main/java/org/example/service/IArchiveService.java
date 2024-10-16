package org.example.service;

import org.example.dto.DocToArchiveDTO;
import org.example.persistence.entity.ArchiveEntity;

import java.util.List;

public interface IArchiveService {

    void saveDocument(DocToArchiveDTO dto);

    List<ArchiveEntity> findAll();

}
