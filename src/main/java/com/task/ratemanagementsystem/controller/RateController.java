package com.task.ratemanagementsystem.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.ratemanagementsystem.exceptions.RateNotFound;
import com.task.ratemanagementsystem.exceptions.ServerException;
import com.task.ratemanagementsystem.model.RateEntity;
import com.task.ratemanagementsystem.model.RateResponse;
import com.task.ratemanagementsystem.service.RateService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/rate")
public class RateController {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(RateController.class);

	@Autowired
	RateService rateService;

	@PostMapping(consumes = "application/json")
	public ResponseEntity<RateEntity> addRate(@RequestBody RateEntity rateEntity) throws ServerException {
		LOGGER.info("Inside RateController Save..");
		return new ResponseEntity<RateEntity>(rateService.saveRate(rateEntity), HttpStatus.CREATED);
	}

	@PutMapping(consumes = "application/json")
	public ResponseEntity<RateEntity> updateRate(@RequestBody RateEntity rateEntity) throws ServerException, RateNotFound {
		return new ResponseEntity<RateEntity>(rateService.updateRate(rateEntity), HttpStatus.OK);
	}

	@GetMapping("/{rateId}")
	public ResponseEntity<RateResponse> getRate(@PathVariable Long rateId) throws ServerException, RateNotFound {

		LOGGER.info("Inside RateController Get..");
		return new ResponseEntity<RateResponse>(rateService.searchRate(rateId), HttpStatus.OK);
	}

	@DeleteMapping("/{rateId}")
	public ResponseEntity<String> deleteRate(@PathVariable Long rateId) throws ServerException, RateNotFound {
		rateService.deleteRate(rateId);
		return new ResponseEntity<String>("Record Deleted", HttpStatus.OK);
	}

}
