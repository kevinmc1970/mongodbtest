package com.test.mongodbtest.document;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class InterestResult {

	@Id
	private Integer id;
	public InterestResult(Integer id, BigDecimal balance, BigDecimal lowRate, BigDecimal medRate, BigDecimal highRate,
						  BigDecimal interest) {
		super();
		this.id = id;
		this.balance = balance;
		this.lowRate = lowRate;
		this.medRate = medRate;
		this.highRate = highRate;
		this.interest = interest;
	}
	private BigDecimal balance;
	private BigDecimal lowRate;
	private BigDecimal medRate;
	private BigDecimal highRate;
	private BigDecimal interest;

}
