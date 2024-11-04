package com.jp.springbatchpoc.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity(name = "event_statuses")
public class EventStatus {
    @Id
    @Column(name = "event_status_code")
    private String eventStatusCode;

    @Column(name = "description")
    private String description;
}
