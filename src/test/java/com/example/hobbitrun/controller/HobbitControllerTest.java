package com.example.hobbitrun.controller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.junit.jupiter.api.Assertions.*;
// Use spring context for tests
@SpringBootTest
// Give some info to Spring on how to create MockMvc
@AutoConfigureMockMvc
class HobbitControllerTest {
    // Ask Spring to inject an instance
    @Autowired
    private MockMvc mockMvc;
    //Regular JUnit
    @Test
    //JUnit5 feature
    @DisplayName("GET /hobbits -> HTTP 200")
    void getAllGetOK() throws Exception {
        // given spring context is ready
        mockMvc
                // when calling /hobbit endpoint
                .perform(MockMvcRequestBuilders.get("/hobbits"))
                // then we should get HTTP 200
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void getAllPOST405() throws Exception {
        // given spring context is ready
        mockMvc
                // when calling /hobbit endpoint
                .perform(MockMvcRequestBuilders.post("/hobbits"))
                // then we should get HTTP 200
                .andExpect(MockMvcResultMatchers.status().is(405));
    }
}