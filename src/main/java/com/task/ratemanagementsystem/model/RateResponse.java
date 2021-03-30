package com.task.ratemanagementsystem.model;

import java.time.LocalDateTime;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateResponse {

	@JsonProperty("rateId")
	private long rateId;

	@JsonProperty("description")
	private String description;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime effectiveDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime expirationDate;

	@JsonProperty("amount")
	private int amount;

	@JsonProperty("surchargeDetails")
	private SurchargeDetails surchargeDetails;

}
