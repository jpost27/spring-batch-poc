package com.jp.springbatchpoc.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity(name = "injury_statuses")
public class InjuryStatus {
    @Id
    @Column(name = "injury_status_code")
    private String injuryStatusCode;

    @Column(name = "description")
    private String description;
}
