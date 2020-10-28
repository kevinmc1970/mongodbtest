package com.mcintech.interest.service;

import com.mcintech.interest.document.InterestResult;
import com.mcintech.interest.repository.InterestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

        if (isLessThan(balance, BigDecimal.ZERO)) {
            return result;
        }
        if (isLessThan(balance, LOW_BAND)) {
            result = addInterest(balance, lowRate, result);
        } else if (isLessThan(balance, MED_BAND)) {
            result = addInterest(LOW_BAND, lowRate, result);
            result = addInterest(balance.subtract(LOW_BAND), medRate, result);
        } else {
            result = addInterest(LOW_BAND, lowRate, result);
            result = addInterest(MED_BAND.subtract(LOW_BAND), medRate, result);
            result = addInterest(balance.subtract(MED_BAND), highRate, result);
        }

        result = result.setScale(2, RoundingMode.DOWN);
        storeResult(balance, lowRate, medRate, highRate, result);
        return result;
    }

    private boolean isLessThan(BigDecimal balance, BigDecimal band) {
        return balance.compareTo(band) <= 0;
    }

    private BigDecimal addInterest(BigDecimal balance, BigDecimal rate, BigDecimal result) {
        return result.add(balance.multiply(getPercentile(rate)));
    }

    private BigDecimal getPercentile(BigDecimal lowRate) {
        return lowRate.divide(ONE_HUNDRED);
    }

    private void storeResult(BigDecimal balance, BigDecimal lowRate, BigDecimal medRate, BigDecimal highRate, BigDecimal result) {
        interestResultRepository.save(new InterestResult(balance, lowRate, medRate, highRate, result));
    }

    public void store(MultipartFile file) throws IOException {
        File path = new File("C:\\Users\\barnh\\savedFile.jpg");
        file.transferTo(path);
    }
}
