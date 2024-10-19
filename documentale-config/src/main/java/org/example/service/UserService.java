package org.example.service;

import org.example.dao.model.DocUser;

import java.util.List;

public interface UserService {

    DocUser saveUser(DocUser content);

    List<DocUser> fetchUserList();


    void deleteUserById(Long id);
}
