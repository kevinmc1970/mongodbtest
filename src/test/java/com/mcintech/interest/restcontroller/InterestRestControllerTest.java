package com.mcintech.interest.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcintech.interest.document.InterestResult;
import com.mcintech.interest.repository.InterestResultRepository;
import com.mcintech.interest.request.InterestCalculatorRequest;
import com.mcintech.interest.service.InterestCalculatorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class InterestRestControllerTest {

    @MockBean
    private InterestCalculatorService interestCalculatorService;
    @MockBean
    private InterestResultRepository interestResultRepository;

    @Autowired
    private MockMvc mvc;

    private final ObjectMapper jsonObjectMapper = new ObjectMapper();
    private InterestResult result;
    private List<InterestResult> listOfResults;
    private InterestCalculatorRequest request;

    @Before
    public void init(){
        result = new InterestResult( new BigDecimal(6400), new BigDecimal(1),
                new BigDecimal(2), new BigDecimal(3), new BigDecimal(132));
        listOfResults = new ArrayList<>();
        listOfResults.add(result);
        request = new InterestCalculatorRequest(new BigDecimal(6400), new BigDecimal(1),
                new BigDecimal(2), new BigDecimal(3));
        when(interestResultRepository.findAll()).thenReturn(listOfResults);
        when(interestCalculatorService.calculateInterest(any(), any(), any(), any()))
                .thenReturn(new BigDecimal("10.00"));
    }

    @Test
    public void getAllResults() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/interest-results/all"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(jsonObjectMapper.writeValueAsString(listOfResults)));
    }

    @Test
    public void calculateInterest() throws Exception {
        mvc.perform(post("/interest-results")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObjectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().json("10.00"));
    }

}
