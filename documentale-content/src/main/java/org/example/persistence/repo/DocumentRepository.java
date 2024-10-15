package org.example.persistence.repo;

import org.example.persistence.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, UUID> {

    //    Optional<ArchiveEntity> findByIdAndDeletedFalse(Long id);
    //
    //    List<ArchiveEntity> findByDeletedFalse();
    //
    //    List<ArchiveEntity> findByCircumscriptionEntityIdAndDeletedFalseOrderByDescriptionAsc(Long CircumscriptionEntityId);
    //
    //    Optional<ArchiveEntity> findByIdAndCircumscriptionEntityIdAndDeletedFalse(Long id, Long circumscriptionEntityId );
}
