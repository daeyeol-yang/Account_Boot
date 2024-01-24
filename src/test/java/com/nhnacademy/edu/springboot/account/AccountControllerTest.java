package com.nhnacademy.edu.springboot.account;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    @Order(1)
    void testGetAccounts() throws Exception{
        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].number",equalTo(1)));
    }

    @Test
    void testGetAccount() throws Exception {

        mockMvc.perform(get("/accounts/{id}",1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.balance",equalTo(1000)));

    }

    @Test
    void testCreateAccount() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        Account account = new Account(4L, 40000);
        mockMvc.perform(post("/accounts").content(objectMapper.writeValueAsString(account))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.balance",equalTo(40000)));
    }

    @Test
    void testDeleteResoponse() throws Exception {
        this.mockMvc.perform(delete("/accounts/{id}",1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result",equalTo("OK")));
    }
}