package com.example.hobbitrun.controller;
import com.example.hobbitrun.model.Hobbit;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// Use spring context for tests
@SpringBootTest
// Give some info to Spring on how to create MockMvc
@AutoConfigureMockMvc
class HobbitControllerTest {
    // Ask Spring to inject an instance
    @Autowired
    private MockMvc mockMvc;
    //Regular JUnit
    @Autowired
    private ObjectMapper objectMapper;
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
    void getAllPOST400() throws Exception {
        // given spring context is ready
        mockMvc
                // when calling /hobbit endpoint
                .perform(post("/hobbits"))
                // then we should get HTTP 200
                .andExpect(status().is(400));
    }

    @Test
    void given3hobbits_whenGETHobbits_thenHTTP200AndListSize3() throws Exception{

        final var mvcResult= mockMvc
                // when calling /hobbit endpoint
                .perform(get("/hobbits"))
                .andDo(print())
                // then we should get HTTP 200
                .andExpect(status().is(200))
                .andReturn();

        final var hobbitsFromDbinJSONFormat=mvcResult.getResponse().getContentAsString();

        List<Hobbit> hobbitsFromDB = objectMapper.readValue(hobbitsFromDbinJSONFormat, new TypeReference<>() {});

        assertEquals(3,hobbitsFromDB.size());
    }

    @Test
    @DirtiesContext
    void given3hobbits_whenPOSTHobbit_thenHTTP200AndHobbitWithId() throws Exception{

        var firstName ="gandalf";
        var lastName ="gandalf";
        var gandalf = new Hobbit(null, firstName,lastName);
        var gandalfAsString = objectMapper.writeValueAsString(gandalf);

        final var mvcResult= mockMvc
                // when calling /hobbit endpoint
                .perform(post("/hobbits")
                        .content(gandalfAsString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                // then we should get HTTP 200
                .andExpect(status().is(200))
                .andReturn();

        final var savedHobbitAsString = mvcResult.getResponse().getContentAsString();

        Hobbit savedHobbit = objectMapper.readValue(savedHobbitAsString, Hobbit.class);

        assertAll(
                () -> assertNotNull(savedHobbit.getId()),
                () -> assertEquals(firstName,savedHobbit.getFirstName()),
                () -> assertEquals(lastName,savedHobbit.getLastName())
        );

    }
}