package com.task.ratemanagementsystem.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "RATE")
public class RateEntity {

	@Id
	@Column(name = "rateid")
	@JsonProperty("rateId")
	private long rateId;

	@Column(name = "rate_desc")
	@JsonProperty("description")
	private String description;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "rate_effective_date", nullable = false)
	private LocalDateTime effectiveDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "rate_expiration_date", nullable = false)
	private LocalDateTime expirationDate;

	@Column(name = "amount", nullable = false)
	@JsonProperty("amount")
	private int amount;

}
