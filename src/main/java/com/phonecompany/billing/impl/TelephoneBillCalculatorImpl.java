package com.phonecompany.billing.impl;

import com.phonecompany.billing.CallCalculator;
import com.phonecompany.billing.PhoneLogParser;
import com.phonecompany.billing.TelephoneBillCalculator;
import com.phonecompany.billing.model.CallLogItem;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
public class TelephoneBillCalculatorImpl implements TelephoneBillCalculator {

    private final PhoneLogParser phoneLogParser;
    private final CallCalculator callCalculator;

    @Override
    public BigDecimal calculate(String phoneLog) {

        BigDecimal bill = BigDecimal.ZERO;
        List<CallLogItem> items = phoneLogParser.parseCsv(phoneLog);

        Iterator<CallLogItem> callLogItemIterator = items.iterator();
        while (callLogItemIterator.hasNext()) {
            bill = bill.add(callCalculator.calculate(callLogItemIterator.next()));
        }

        return bill;
    }
}
