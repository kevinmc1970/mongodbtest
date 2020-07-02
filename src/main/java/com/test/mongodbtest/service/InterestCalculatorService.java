package com.test.mongodbtest.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class InterestCalculatorService {

    private static BigDecimal lowBand = new BigDecimal("1000.00");
    private static BigDecimal medBand = new BigDecimal("5000.00");
    public BigDecimal calculateInterest(BigDecimal balance, BigDecimal lowRate, BigDecimal medRate,
                                        BigDecimal highRate) {

        BigDecimal result = BigDecimal.ZERO;
        BigDecimal hundred = new BigDecimal("100.00");
//        1. The first 1000 gains 1%
//                2. Between 1000 and 5000 gains 2%
//                3. Greater than 5000 gains 3%
//                Example: 6400 would gain an interest of 132
        if (balance.compareTo(BigDecimal.ZERO) <=0) {
            return result;
        }
        if (balance.compareTo(lowBand) <= 0) {
            result = result.add(balance.multiply(lowRate.divide(hundred)));
        } else if (balance.compareTo(medBand) <= 0) {
            result = result.add(lowBand.multiply(lowRate.divide(hundred)));
            result = result.add(balance.subtract(lowBand).multiply(medRate.divide(hundred)));
        } else {
            result = result.add(lowBand.multiply(lowRate.divide(hundred)));
            result = result.add(medBand.subtract(lowBand).multiply(medRate.divide(hundred)));
            result = result.add(balance.subtract(medBand).multiply(highRate.divide(hundred)));
        }
        return result.setScale(2, RoundingMode.DOWN);
    }
}
