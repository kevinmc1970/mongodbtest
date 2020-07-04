package com.mcintech.interest.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class InterestCalculatorRequest {

    @NotNull
    @Min(value = 1, message = "minimum value is 1.00")
    private BigDecimal balance;
    @NotNull
    @Min(value = 1, message = "minimum value is 1.00")
    private BigDecimal lowRate;
    @NotNull
    @Min(value = 1, message = "minimum value is 1.00")
    private BigDecimal medRate;
    @NotNull
    @Min(value = 1, message = "minimum value is 1.00")
    private BigDecimal highRate;

    public InterestCalculatorRequest() {}

    public InterestCalculatorRequest(BigDecimal balance, BigDecimal lowRate, BigDecimal medRate, BigDecimal highRate) {
        this.balance = balance;
        this.lowRate = lowRate;
        this.medRate = medRate;
        this.highRate = highRate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLowRate() {
        return lowRate;
    }

    public void setLowRate(BigDecimal lowRate) {
        this.lowRate = lowRate;
    }

    public BigDecimal getMedRate() {
        return medRate;
    }

    public void setMedRate(BigDecimal medRate) {
        this.medRate = medRate;
    }

    public BigDecimal getHighRate() {
        return highRate;
    }

    public void setHighRate(BigDecimal highRate) {
        this.highRate = highRate;
    }

}
