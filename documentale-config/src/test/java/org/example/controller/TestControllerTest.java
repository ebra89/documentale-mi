package org.example.controller;

import org.example.service.TestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TestControllerTest {

    private TestService testService;

    @BeforeEach
    void setup(){
        testService = mock(TestService.class);
    }

    @Test
    void testGetTest(){
        when(testService.getTestMessage()).thenReturn("AAA");
        DocConfController testController = new DocConfController(testService);
        ResponseEntity<String> response = testController.test();
        assertEquals("AAA", response.getBody());
    }


    @Test
    void testGetTest2(){
        doReturn("BBB").when(testService).getTestMessage();
        DocConfController testController = new DocConfController(testService);
        ResponseEntity<String> response = testController.test();
        assertEquals("BBB", response.getBody());
    }

    @Test
    void testNotException(){
        when(testService.getTestMessage()).thenReturn("AAA");
        DocConfController testController = new DocConfController(testService);
        ResponseEntity<String> response = testController.test();
        assertEquals("AAA", response.getBody());
        assertThat(response.getBody()).isNotNull();
        assertThatCode(() -> testController.test()).doesNotThrowAnyException();
    }
}
