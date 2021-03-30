package com.task.ratemanagementsystem.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.task.ratemanagementsystem.exceptions.RateNotFound;
import com.task.ratemanagementsystem.exceptions.ServerException;
import com.task.ratemanagementsystem.model.RateEntity;
import com.task.ratemanagementsystem.model.RateResponse;
import com.task.ratemanagementsystem.model.SurchargeDetails;
import com.task.ratemanagementsystem.repository.RateRepository;
import com.task.ratemanagementsystem.restservice.SurchargeService;
import com.task.ratemanagementsystem.service.RateService;

@Component
public class RateServiceImpl implements RateService {

	@Autowired
	RateRepository rateRepo;

	@Autowired
	SurchargeService service;

	@Override
	public RateEntity saveRate(RateEntity entity) throws ServerException {
		return rateRepo.save(entity);
	}

	@Override
	public RateResponse searchRate(Long rateId) throws RateNotFound, ServerException {
		Optional<RateEntity> entity = rateRepo.findById(rateId);
		if (entity.isEmpty()) {
			throw new RateNotFound("RateId not found in RMS");
		}
		RateResponse response = new RateResponse();
		BeanUtils.copyProperties(entity.get(), response);
		SurchargeDetails details = service.getSurchargeDetails();
		response.setSurchargeDetails(details);
		return response;
	}

	@Override
	public RateEntity updateRate(RateEntity entity) throws ServerException, RateNotFound {
		Optional<RateEntity> optinalEntity = rateRepo.findById(entity.getRateId());
		if (optinalEntity.isEmpty()) {
			throw new RateNotFound("RateId not found in RMS");
		}
		BeanUtils.copyProperties(entity, optinalEntity.get());
		return rateRepo.save(optinalEntity.get());
	}

	@Override
	public void deleteRate(Long rateId) throws RateNotFound, ServerException {
		Optional<RateEntity> entity = rateRepo.findById(rateId);
		if (entity.isEmpty()) {
			throw new RateNotFound("RateId not found in RMS");
		}
		rateRepo.delete(entity.get());
	}

}
