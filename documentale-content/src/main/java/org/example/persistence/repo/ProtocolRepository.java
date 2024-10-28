package org.example.persistence.repo;

import org.example.persistence.entity.ProtocolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocolRepository extends JpaRepository<ProtocolEntity, Long> {

}