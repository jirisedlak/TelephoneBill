package com.phonecompany.billing.impl;

import com.phonecompany.billing.CallCalculator;
import com.phonecompany.billing.model.CallLogItem;
import com.phonecompany.billing.properties.CallCalculatorProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalTime;

@Slf4j
@RequiredArgsConstructor
public class CallCalculatorImpl implements CallCalculator {

    private final CallCalculatorProperties properties;

    @Override
    public BigDecimal calculate(CallLogItem callLogItem) {
        if (callLogItem == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal bill = BigDecimal.ZERO;

        log.debug("Calculating bill for call item: {}", callLogItem);

        int minuteCounter = 1;
        LocalTime currentMinute = callLogItem.getStartedAt().toLocalTime();
        do {
            bill.add(calculateMinuteFee(currentMinute, minuteCounter));
            minuteCounter += 1;
            currentMinute.plusMinutes(1);
        } while (currentMinute.isBefore(callLogItem.getFinishedAt().toLocalTime()));



        return bill;
    }

    private BigDecimal calculateMinuteFee(LocalTime time, int minuteCounter) {
        if (minuteCounter > properties.getLowFeeThreshold()) {
            return properties.getHighDurationFee();
        }
        if (time.isBefore(properties.getHighFeeStart()) || time.isAfter(properties.getHighFeeEnd())) {
            return properties.getLowFee();
        }

        return properties.getHighFee();
    }


}
