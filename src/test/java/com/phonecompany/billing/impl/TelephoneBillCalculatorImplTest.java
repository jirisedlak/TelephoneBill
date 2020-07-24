package com.phonecompany.billing.impl;

import com.phonecompany.billing.CallCalculator;
import com.phonecompany.billing.PhoneLogParser;
import com.phonecompany.billing.TelephoneBillCalculator;
import com.phonecompany.billing.properties.CallCalculatorProperties;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TelephoneBillCalculatorImplTest {

    private TelephoneBillCalculatorImpl calculator;

    @Before
    public void setup() {
        PhoneLogParser parser = new PhoneLogParserImpl();
        CallCalculatorProperties callCalculatorProperties = new CallCalculatorProperties();
        CallCalculator callCalculator = new CallCalculatorImpl(callCalculatorProperties);
        calculator = new TelephoneBillCalculatorImpl(parser, callCalculator);
    }


    @Test
    public void testCalculate() {

        String inputCallLog = "420774577453,13-01-2020 18:10:15,13-01-2020 18:12:57\n420776562353,18-01-2020 08:59:20,18-01-2020 09:10:00";

        BigDecimal amount = calculator.calculate(inputCallLog);

        assertEquals(new BigDecimal("10"), amount);
    }
}
