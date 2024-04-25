package com.jp.springbatchpoc.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TeamColorTypes {

    PRIMARY("PRIMARY"),
    SECONDARY("SECONDARY"),
    ;

    private final String typeName;

}
