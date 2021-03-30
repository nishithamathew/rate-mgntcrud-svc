package com.task.ratemanagementsystem.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	private int port;

	@MockBean
	RateService service;

	@MockBean
	RateEntity rateEntity;

	@MockBean
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
	void testSaveRate() {
		Mockito.when(service.saveRate(Mockito.any())).thenReturn(rateEntity);
		ResponseEntity<RateEntity> rateEntity = testRestTemplate.postForEntity("http://localhost:" + port + "/rate",
				RateEntity.class, null);
		assertNotNull(rateEntity);
	}

}
