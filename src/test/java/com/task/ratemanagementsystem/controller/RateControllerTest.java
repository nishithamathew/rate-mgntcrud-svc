package com.task.ratemanagementsystem.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import com.task.ratemanagementsystem.exceptions.RateNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.task.ratemanagementsystem.model.RateEntity;
import com.task.ratemanagementsystem.model.RateResponse;
import com.task.ratemanagementsystem.model.SurchargeDetails;
import com.task.ratemanagementsystem.service.RateService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RateControllerTest {

	@InjectMocks
	RateController rateController;

	@Mock
	RateService service;

	@Mock
	RateEntity rateEntity;

	@Mock
	RateResponse rateResp;

	@BeforeEach
	void setUp() {
		this.rateEntity = new RateEntity();
		this.rateResp = new RateResponse();
		rateEntity.setRateId(1001);
		rateEntity.setEffectiveDate(LocalDateTime.now());
		rateEntity.setEffectiveDate(LocalDateTime.now());
		rateEntity.setDescription("Test");
		rateEntity.setAmount(10000);

		rateResp.setRateId(1001);
		rateResp.setEffectiveDate(LocalDateTime.now());
		rateResp.setEffectiveDate(LocalDateTime.now());
		rateResp.setDescription("Test");
		rateResp.setAmount(10000);
		SurchargeDetails details = new SurchargeDetails();
		details.setSurchargeRate(100);
		details.setSurchargeDescription("VAT");
	}

	@Test
	void testAddRate() {
		Mockito.when(service.saveRate(rateEntity)).thenReturn(rateEntity);
		rateController.addRate(rateEntity);
	}
	@Test
	void testUpdateRate() throws RateNotFound {
		Mockito.when(service.updateRate(rateEntity)).thenReturn(rateEntity);
		rateController.updateRate(rateEntity);
	}
	@Test
	void testGetRate() throws RateNotFound {
		Mockito.when(service.searchRate(rateEntity.getRateId())).thenReturn(rateResp);
		rateController.getRate(rateEntity.getRateId());
	}
	@Test
	void testDeleteRate() throws RateNotFound {
		rateController.deleteRate(rateEntity.getRateId());
	}
}
