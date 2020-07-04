package com.mcintech.interest.service;

import com.mcintech.interest.document.InterestResult;
import com.mcintech.interest.repository.InterestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class InterestCalculatorService {

    @Autowired
    private InterestResultRepository interestResultRepository;

    private static BigDecimal LOW_BAND = new BigDecimal("1000.00");
    private static BigDecimal MED_BAND = new BigDecimal("5000.00");
    private static BigDecimal ONE_HUNDRED = new BigDecimal("100.00");
    public BigDecimal calculateInterest(BigDecimal balance, BigDecimal lowRate, BigDecimal medRate,
                                        BigDecimal highRate) {

        BigDecimal result = BigDecimal.ZERO;

        if (balance.compareTo(BigDecimal.ZERO) <=0) {
            return result;
        }
        if (balance.compareTo(LOW_BAND) <= 0) {
            result = result.add(balance.multiply(lowRate.divide(ONE_HUNDRED)));
        } else if (balance.compareTo(MED_BAND) <= 0) {
            result = result.add(LOW_BAND.multiply(lowRate.divide(ONE_HUNDRED)));
            result = result.add(balance.subtract(LOW_BAND).multiply(medRate.divide(ONE_HUNDRED)));
        } else {
            result = result.add(LOW_BAND.multiply(lowRate.divide(ONE_HUNDRED)));
            result = result.add(MED_BAND.subtract(LOW_BAND).multiply(medRate.divide(ONE_HUNDRED)));
            result = result.add(balance.subtract(MED_BAND).multiply(highRate.divide(ONE_HUNDRED)));
        }

        result = result.setScale(2, RoundingMode.DOWN);
        storeResult(balance, lowRate, medRate, highRate, result);
        return result;
    }

    private void storeResult(BigDecimal balance, BigDecimal lowRate, BigDecimal medRate, BigDecimal highRate, BigDecimal result) {
        interestResultRepository.save(new InterestResult(balance, lowRate, medRate, highRate, result));
    }
}
