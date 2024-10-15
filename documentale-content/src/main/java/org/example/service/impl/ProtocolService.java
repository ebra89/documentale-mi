package org.example.service.impl;

import org.example.service.IProtocolService;
import org.springframework.stereotype.Service;

@Service
public class ProtocolService implements IProtocolService {

    public String getTestMessage(){
        return "TEST MESSAGE FROM DOC-CONTENT";
    }

}
