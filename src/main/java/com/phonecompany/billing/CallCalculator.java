package com.phonecompany.billing;

import com.phonecompany.billing.model.CallLogItem;

import java.math.BigDecimal;

public interface CallCalculator {

    BigDecimal calculate(CallLogItem callLogItem);
}
