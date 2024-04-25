package com.jp.springbatchpoc.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TeamAssociationTypes {

    CONFERENCE("CONFERENCE"),
    DIVISION("DIVISION"),
    LEAGUE("LEAGUE"),
    ;
    private final String associationName;

}
