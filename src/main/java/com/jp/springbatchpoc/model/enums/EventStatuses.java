package com.jp.springbatchpoc.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventStatuses {
    SCHEDULED("SCHEDULED", "Scheduled"),
    IN_PROGRESS("IN_PROGRESS", "In Progress"),
    CANCELLED("CANCELLED", "Cancelled"),
    POSTPONED("POSTPONED", "Postponed"),
    DELAYED("DELAYED", "Delayed"),
    SUSPENDED("SUSPENDED", "Suspended"),
    FINAL("FINAL", "Final"),
    ;

    private final String statusCode;
    private final String description;
}
