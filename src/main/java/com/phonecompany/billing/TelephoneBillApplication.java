package com.phonecompany.billing;

import com.phonecompany.billing.impl.CallCalculatorImpl;
import com.phonecompany.billing.impl.PhoneLogParserImpl;
import com.phonecompany.billing.impl.TelephoneBillCalculatorImpl;
import com.phonecompany.billing.properties.CallCalculatorProperties;

import java.math.BigDecimal;

public class TelephoneBillApplication {

    public static void main(String[] args) {
        PhoneLogParser parser = new PhoneLogParserImpl();
        CallCalculatorProperties callCalculatorProperties = new CallCalculatorProperties();
        CallCalculator callCalculator = new CallCalculatorImpl(callCalculatorProperties);

        TelephoneBillCalculator calculator = new TelephoneBillCalculatorImpl(parser, callCalculator);

        BigDecimal bill = calculator.calculate(args[1]);

        System.out.println(bill);
    }

}
