package com.phonecompany.billing.properties;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalTime;

@Data
public class CallCalculatorProperties {

    private BigDecimal lowFee = new BigDecimal("1");
    private BigDecimal highFee = new BigDecimal("0.5");
    private BigDecimal highDurationFee = new BigDecimal("0.2");

    private int lowFeeThreshold = 5;
    private LocalTime highFeeStart = LocalTime.of(8, 0);
    private LocalTime highFeeEnd = LocalTime.of(16, 0);
}
