package com.phonecompany.billing.impl;

import com.phonecompany.billing.PhoneLogParser;
import com.phonecompany.billing.model.CallLogItem;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class PhoneLogParserImpl implements PhoneLogParser {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @Override
    public List<CallLogItem> parseCsv(String inputCsv) {
        LinkedList<CallLogItem> items = new LinkedList<>();

        if (isEmpty(inputCsv)) {
            return items;
        }

        String[] lines = inputCsv.split("\\n");
        for (int i = 0; i < lines.length; i++) {
            items.add(parseLine(lines[i]));
        }

        return items;
    }


    private CallLogItem parseLine(String line) {
        if (isEmpty(line)) {
            return null;
        }

        log.debug("Parsing line: {}", line);
        String[] items = line.split(",");
        return CallLogItem.builder()
                .phoneNumber(parseString(items[0]))
                .startedAt(parseLocalDateTime(items[1]))
                .finishedAt(parseLocalDateTime(items[2]))
                .build();
    }

    private boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    private String parseString(String item) {
        if (item == null || item.trim().isEmpty()) {
            return "";
        }
        return item;
    }

    private LocalDateTime parseLocalDateTime(String item) {
        return LocalDateTime.parse(parseString(item), formatter);
    }
}
