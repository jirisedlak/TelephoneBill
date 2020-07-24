package com.phonecompany.billing.model;

import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@Builder
public class CallLogItem {

    private String phoneNumber;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;


    public Duration getCallDuration() {
        return Duration.between(finishedAt, startedAt);
    }
}
