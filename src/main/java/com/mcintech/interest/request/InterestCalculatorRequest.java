package com.mcintech.interest.request;

import java.math.BigDecimal;

public class InterestCalculatorRequest {


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

    private BigDecimal balance;
    private BigDecimal lowRate;
    private BigDecimal medRate;
    private BigDecimal highRate;

}
