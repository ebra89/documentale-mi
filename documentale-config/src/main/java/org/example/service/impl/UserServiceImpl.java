package org.example.service.impl;

import org.example.dao.UserRepository;
import org.example.dao.model.DocUser;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public DocUser saveUser(DocUser user) {
        return userRepository.save(user);
    }

    @Override
    public List<DocUser> fetchUserList() {
        return (List<DocUser>) userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);

    }
}
