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
        DocApiController docApiController = new DocApiController(testService);
        ResponseEntity<String> response = docApiController.test();
        assertEquals("AAA", response.getBody());
    }


    @Test
    void testGetTest2(){
        doReturn("BBB").when(testService).getTestMessage();
        DocApiController docApiController = new DocApiController(testService);
        ResponseEntity<String> response = docApiController.test();
        assertEquals("BBB", response.getBody());
    }

    @Test
    void testNotException(){
        when(testService.getTestMessage()).thenReturn("AAA");
        DocApiController docApiController = new DocApiController(testService);
        ResponseEntity<String> response = docApiController.test();
        assertEquals("AAA", response.getBody());
        assertThat(response.getBody()).isNotNull();
        assertThatCode(() -> docApiController.test()).doesNotThrowAnyException();
    }
}
