package com.phonecompany.billing;

import com.phonecompany.billing.model.CallLogItem;

import java.util.List;

public interface PhoneLogParser {

    List<CallLogItem> parseCsv(String inputCsv);

}
