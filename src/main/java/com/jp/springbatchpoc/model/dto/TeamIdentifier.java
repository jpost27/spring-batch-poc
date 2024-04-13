package com.jp.springbatchpoc.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
@Getter(AccessLevel.PRIVATE)
public class TeamIdentifier implements Serializable {

    private Integer fanDuelId;
    private List<Long> sportsbookIds;
    private Integer numberFireId;
    private String sportRadarId;
    private String teamName;

}
