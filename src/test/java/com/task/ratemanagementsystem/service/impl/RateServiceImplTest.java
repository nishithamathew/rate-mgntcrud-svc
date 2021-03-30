package com.task.ratemanagementsystem.service.impl;

import com.task.ratemanagementsystem.exceptions.RateNotFound;
import com.task.ratemanagementsystem.model.RateEntity;
import com.task.ratemanagementsystem.model.RateResponse;
import com.task.ratemanagementsystem.model.SurchargeDetails;
import com.task.ratemanagementsystem.repository.RateRepository;
import com.task.ratemanagementsystem.restservice.SurchargeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RateServiceImplTest {

    @InjectMocks
    RateServiceImpl rateService;

    @Mock
    RateRepository rateRepository;

    @Mock
    RateEntity rateEntity;

    @Mock
    RateResponse response;

    @Mock
    SurchargeService service;

    @Test
    void testSaveRate() {
        rateEntity = generateRequest();
        Mockito.when(rateRepository.save(rateEntity)).thenReturn(Mockito.any());
        rateEntity = rateService.saveRate(rateEntity);
    }

    private RateEntity generateRequest() {
        RateEntity entity = new RateEntity();
        entity.setRateId(2);
        entity.setAmount(500);
        entity.setDescription("rate second");
        entity.setEffectiveDate(LocalDateTime.now());
        entity.setExpirationDate(LocalDateTime.now());
        return entity;
    }
    @Test
    void testSearchRate() throws RateNotFound {
        SurchargeDetails details = new SurchargeDetails();
        details.setSurchargeDescription("VAT");
        details.setSurchargeRate(100);
        rateEntity = generateRequest();
        Optional<RateEntity> entity = Optional.of(rateEntity);
        Mockito.when(rateRepository.findById(2L)).thenReturn(entity);
        Mockito.when(service.getSurchargeDetails()).thenReturn(details);
        response = rateService.searchRate(2L);
    }
    @Test
    void testUpdateRate() throws RateNotFound {
        rateEntity = generateRequest();
        Optional<RateEntity> entity = Optional.of(rateEntity);
        Mockito.when(rateRepository.findById(2L)).thenReturn(entity);
        Mockito.when(rateRepository.save(rateEntity)).thenReturn(Mockito.any());
        rateEntity = rateService.updateRate(rateEntity);
    }
    @Test
    void testDeleteRate() throws RateNotFound {
        rateEntity = generateRequest();
        Optional<RateEntity> entity = Optional.of(rateEntity);
        Mockito.when(rateRepository.findById(2L)).thenReturn(entity);
        rateService.deleteRate(2L);
    }
}