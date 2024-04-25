package com.jp.springbatchpoc.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class TeamIdentifier implements Serializable {

    private Integer fanDuelId;
    private List<Long> sportsbookIds;
    private Integer numberFireId;
    private String sportRadarId;
    private String teamName;

}
