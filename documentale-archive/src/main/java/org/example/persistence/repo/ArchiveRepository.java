package org.example.persistence.repo;

import org.example.persistence.entity.ArchiveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArchiveRepository extends JpaRepository<ArchiveEntity, UUID> {

}
