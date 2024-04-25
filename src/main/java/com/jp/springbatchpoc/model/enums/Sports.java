package com.jp.springbatchpoc.model.enums;

import com.jp.springbatchpoc.model.entity.Sport;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
public enum Sports {

    AMERICAN_FOOTBALL("American Football"),
    BASEBALL("Baseball"),
    BASKETBALL("Basketball"),
    ;

    @Getter private final String sportName;

    public static Optional<Sports> fromSport(Sport sport) {
        return Arrays.stream(values())
                .filter(sportEnum -> sportEnum.sportName.equals(sport.getName()))
                .findFirst();
    }
}
