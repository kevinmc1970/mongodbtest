package com.test.mongodbtest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class InterestCalculatorServiceTest {

    @InjectMocks
    private InterestCalculatorService onTest;

    @Test
    public void givenBalance_calculateCorrectInterestRate() {
        BigDecimal balance = new BigDecimal("6400.00");
        BigDecimal lowRate = new BigDecimal("1.00");
        BigDecimal medRate = new BigDecimal("2.00");
        BigDecimal highRate = new BigDecimal("3.00");
        BigDecimal expectedInterest = new BigDecimal("132.00");
        assertTrue(onTest.calculateInterest(balance, lowRate, medRate, highRate)
                .compareTo(expectedInterest) == 0 );
    }

    @Test
    public void givenBalance999_calculateCorrectInterestRate() {
        BigDecimal balance = new BigDecimal("999.99");
        BigDecimal lowRate = new BigDecimal("1.00");
        BigDecimal medRate = new BigDecimal("2.00");
        BigDecimal highRate = new BigDecimal("3.00");
        BigDecimal expectedInterest = new BigDecimal("9.99");
        assertTrue(onTest.calculateInterest(balance, lowRate, medRate, highRate)
                .compareTo(expectedInterest) == 0 );
    }

    @Test
    public void givenBalance1000_calculateCorrectInterestRate() {
        BigDecimal balance = new BigDecimal("1000");
        BigDecimal lowRate = new BigDecimal("1.00");
        BigDecimal medRate = new BigDecimal("2.00");
        BigDecimal highRate = new BigDecimal("3.00");
        BigDecimal expectedInterest = new BigDecimal("10.00");
        assertTrue(onTest.calculateInterest(balance, lowRate, medRate, highRate)
                .compareTo(expectedInterest) == 0 );
    }

    @Test
    public void givenBalance1001_calculateCorrectInterestRate() {
        BigDecimal balance = new BigDecimal("1001");
        BigDecimal lowRate = new BigDecimal("1.00");
        BigDecimal medRate = new BigDecimal("2.00");
        BigDecimal highRate = new BigDecimal("3.00");
        BigDecimal expectedInterest = new BigDecimal("10.02");
        assertTrue(onTest.calculateInterest(balance, lowRate, medRate, highRate)
                .compareTo(expectedInterest) == 0 );
    }

    @Test
    public void givenBalance4999_calculateCorrectInterestRate() {
        BigDecimal balance = new BigDecimal("4999.99");
        BigDecimal lowRate = new BigDecimal("1.00");
        BigDecimal medRate = new BigDecimal("2.00");
        BigDecimal highRate = new BigDecimal("3.00");
        BigDecimal expectedInterest = new BigDecimal("89.99");
        assertTrue(onTest.calculateInterest(balance, lowRate, medRate, highRate)
                .compareTo(expectedInterest) == 0 );
    }

    @Test
    public void givenBalance5000_calculateCorrectInterestRate() {
        BigDecimal balance = new BigDecimal("5000");
        BigDecimal lowRate = new BigDecimal("1.00");
        BigDecimal medRate = new BigDecimal("2.00");
        BigDecimal highRate = new BigDecimal("3.00");
        BigDecimal expectedInterest = new BigDecimal("90.00");
        assertTrue(onTest.calculateInterest(balance, lowRate, medRate, highRate)
                .compareTo(expectedInterest) == 0 );
    }

    @Test
    public void givenBalance5001_calculateCorrectInterestRate() {
        BigDecimal balance = new BigDecimal("5001");
        BigDecimal lowRate = new BigDecimal("1.00");
        BigDecimal medRate = new BigDecimal("2.00");
        BigDecimal highRate = new BigDecimal("3.00");
        BigDecimal expectedInterest = new BigDecimal("90.03");
        assertTrue(onTest.calculateInterest(balance, lowRate, medRate, highRate)
                .compareTo(expectedInterest) == 0 );
    }

    @Test
    public void givenBalanceZero_calculateCorrectInterestRate_theInterestZero() {
        BigDecimal balance = new BigDecimal("0");
        BigDecimal lowRate = new BigDecimal("1.00");
        BigDecimal medRate = new BigDecimal("2.00");
        BigDecimal highRate = new BigDecimal("3.00");
        BigDecimal expectedInterest = new BigDecimal("0.00");
        assertTrue(onTest.calculateInterest(balance, lowRate, medRate, highRate)
                .compareTo(expectedInterest) == 0 );
    }

    @Test
    public void givenBalanceInDebit_calculateCorrectInterestRate_thenInterestZero() {
        BigDecimal balance = new BigDecimal("-100");
        BigDecimal lowRate = new BigDecimal("1.00");
        BigDecimal medRate = new BigDecimal("2.00");
        BigDecimal highRate = new BigDecimal("3.00");
        BigDecimal expectedInterest = new BigDecimal("0.00");
        assertTrue(onTest.calculateInterest(balance, lowRate, medRate, highRate)
                .compareTo(expectedInterest) == 0 );
    }
}
