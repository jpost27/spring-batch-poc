package com.jp.springbatchpoc.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SeasonTypes {
    REGULAR("REGULAR"),
    PRE("PRE"),
    POST("POST"),
    ;

    private final String typeCode;
}
