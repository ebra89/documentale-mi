package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String getTestMessage(){
        return "TEST MESSAGE FROM DOC-CONFIG";
    }

}
