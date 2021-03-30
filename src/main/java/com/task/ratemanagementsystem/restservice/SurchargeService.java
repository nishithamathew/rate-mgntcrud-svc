package com.task.ratemanagementsystem.restservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.task.ratemanagementsystem.model.SurchargeDetails;

@Service
public class SurchargeService {

	@Value("${surchargeAPI}")
	private String surchargeAPI;

	@Bean
	public RestTemplate restTemplate() {
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON));
		converters.add(converter);
		return new RestTemplate(converters);
	}

	@Autowired
	RestTemplate restTemplate;

	public SurchargeDetails getSurchargeDetails() {

		return restTemplate.getForObject(surchargeAPI, SurchargeDetails.class);
	}

}
