package com.thiethaa.student_docker.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class StudentControllerTest {
    private final String baseURL = "/students";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentController studentController;

    @Test
    void getStudentsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(baseURL)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}