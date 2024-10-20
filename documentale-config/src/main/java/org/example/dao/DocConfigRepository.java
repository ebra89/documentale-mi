package org.example.dao;

import org.example.dao.model.DocConfig;
import org.springframework.data.repository.CrudRepository;

public interface DocConfigRepository extends CrudRepository<DocConfig,Long> {
    DocConfig findByDepartment(String department);
}
