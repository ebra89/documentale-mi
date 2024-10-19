package org.example.dao;

import org.example.dao.model.DocUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<DocUser,Long> {
}
