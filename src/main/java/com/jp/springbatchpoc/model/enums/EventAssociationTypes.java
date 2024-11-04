package com.jp.springbatchpoc.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventAssociationTypes {
    TOURNAMENT("TOURNAMENT"),
    CHAMPIONSHIP("CHAMPIONSHIP"),
    ;

    private final String typeCode;
}
