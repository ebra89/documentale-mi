package org.example.controller;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTestInt {

    @Autowired
    private MockMvc mockMvc; // Inietta MockMvc per simulare chiamate HTTP

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetMethod() throws Exception {
        mockMvc.perform(get("/test")) // Simula una richiesta GET all'endpoint "/test"
                .andExpect(status().isOk()) // Verifica che la risposta abbia status 200 (OK)
                .andExpect(MockMvcResultMatchers.content().contentType("application/json")); // Verifica che il content-type sia JSON
                //.andReturn().getResponse().getContentAsString().equals("TEST MESSAGE");
    }

}