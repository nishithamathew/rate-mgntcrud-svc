package com.task.ratemanagementsystem.service;

import org.springframework.stereotype.Service;

import com.task.ratemanagementsystem.exceptions.RateNotFound;
import com.task.ratemanagementsystem.exceptions.ServerException;
import com.task.ratemanagementsystem.model.RateEntity;
import com.task.ratemanagementsystem.model.RateResponse;

@Service
public interface RateService {
	RateEntity saveRate(RateEntity entity) throws ServerException;

	RateResponse searchRate(Long rateId) throws RateNotFound, ServerException;

	RateEntity updateRate(RateEntity entity) throws ServerException, RateNotFound;

	void deleteRate(Long rateId) throws RateNotFound, ServerException;

}
