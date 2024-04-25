package com.jp.springbatchpoc.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class CompetitorIdentifier implements Serializable {

    private Integer fanDuelId;
    private Integer teamFanDuelId;
    private List<Long> sportsbookIds;
    private Integer numberFireId;
    private Integer teamNumberFireId;
    private String sportRadarId;
    private String teamSportRadarId;
    private List<String> teamSportBookIds;
    private String name;

}
