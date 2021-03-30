package com.task.ratemanagementsystem.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RateEntityTest {
    RateEntity rateEntity = new RateEntity();

    @Test
    void test() {
        rateEntity = setAllFields();
        assertEquals(2,rateEntity.getRateId());
        assertEquals(500,rateEntity.getAmount());
        assertEquals("rate second",rateEntity.getDescription());
        assertEquals(LocalDateTime.now(),rateEntity.getEffectiveDate());
        assertEquals(LocalDateTime.now(),rateEntity.getExpirationDate());
    }

    private RateEntity setAllFields() {
        RateEntity entity = new RateEntity();
        entity.setRateId(2);
        entity.setAmount(500);
        entity.setDescription("rate second");
        entity.setEffectiveDate(LocalDateTime.now());
        entity.setExpirationDate(LocalDateTime.now());
        return entity;
    }
}