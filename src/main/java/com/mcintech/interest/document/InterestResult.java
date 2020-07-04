package com.mcintech.interest.document;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.math.BigDecimal;
import java.util.UUID;

@Document
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class InterestResult {

	private BigDecimal balance;
	private BigDecimal lowRate;
	private BigDecimal medRate;
	private BigDecimal highRate;
	private BigDecimal interest;

	public InterestResult(BigDecimal balance, BigDecimal lowRate, BigDecimal medRate, BigDecimal highRate,
						  BigDecimal interest) {
		super();
		this.balance = balance;
		this.lowRate = lowRate;
		this.medRate = medRate;
		this.highRate = highRate;
		this.interest = interest;
	}
}
