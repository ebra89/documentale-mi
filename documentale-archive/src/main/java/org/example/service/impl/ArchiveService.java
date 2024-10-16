package org.example.service.impl;

import org.example.dto.DocToArchiveDTO;
import org.example.persistence.entity.ArchiveEntity;
import org.example.persistence.repo.ArchiveRepository;
import org.example.service.IArchiveService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ArchiveService implements IArchiveService {

    private final ArchiveRepository archiveRepository;

    public ArchiveService(ArchiveRepository archiveRepository) {
        this.archiveRepository = archiveRepository;
    }

    public void saveDocument(DocToArchiveDTO dto) {
        ArchiveEntity archive = new ArchiveEntity();
        archive.setDocumentId(dto.getDocumentId());
        archive.setArchiveUserId(dto.getArchiveUserId());
        archive.setArchiveDate(LocalDate.now());
        archive.setState("OK");
        archive.setCreateDate(LocalDateTime.now());
        archive.setCreateUser("luca.verdi@doc.it");
        archive.setLocation("MI");
        archiveRepository.save(archive);
    }

}
