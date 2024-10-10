package org.example.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceTest {

    private TestService testService = new TestService();

    @Test
    void getTestMessage(){
        String result = testService.getTestMessage();
        assertEquals("TEST MESSAGE", result);
    }

}
