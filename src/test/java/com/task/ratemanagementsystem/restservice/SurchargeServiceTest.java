package com.task.ratemanagementsystem.restservice;

import com.task.ratemanagementsystem.model.SurchargeDetails;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SurchargeServiceTest {

    @InjectMocks
    SurchargeService surchargeService;

    @Value("${surchargeAPI}")
    private String surchargeAPI;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    SurchargeDetails surchargeDetails;

    @Test
    void testGetSurchargeDetails() {
        SurchargeDetails details = new SurchargeDetails();
        details.setSurchargeDescription("VAT");
        details.setSurchargeRate(100);
        Mockito.when(restTemplate.getForObject(surchargeAPI,SurchargeDetails.class)).thenReturn(details);
        surchargeService.getSurchargeDetails();
    }
}