package com.jp.springbatchpoc.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.NonNull;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum Leagues {
    MLB(Sports.BASEBALL, "MLB", "Major League Baseball", "MLB", "51"),
    NBA(Sports.BASKETBALL, "NBA", "National Basketball Association", "NBA", "62"),
    NCAAF(Sports.AMERICAN_FOOTBALL, "NCAAF", "NCAA Football", "NCAAF", "64"),
    NCAAMB(Sports.BASKETBALL, "NCAAMB", "NCAA Men's Basketball", "NCAAB", "63"),
    NCAAWB(Sports.BASKETBALL, "NCAAWB", "NCAA Women's Basketball", null, null),
    NFL(Sports.AMERICAN_FOOTBALL, "NFL", "National Football League", "NFL", "11"),
    WNBA(Sports.BASKETBALL, "WNBA", "Women's National Basketball Association", null, null),
    ;

    private final Sports sport;
    private final String abbreviatedName;
    private final String fullName;
    private final String numberFireLeagueCode;
    /*
    FanDuel competition ID is NOT associated with sportsbook (SCAN/SMP) Competitions
    */
    private final String fanDuelCompetitionId;

    @Override
    public String toString() {
        return abbreviatedName;
    }

    public static Optional<Leagues> fromString(@NonNull String fromString) {
        return Arrays.stream(Leagues.values())
                .filter(leagueCd ->
                        leagueCd.name().equalsIgnoreCase(fromString) || leagueCd.abbreviatedName.equalsIgnoreCase(fromString))
                .findFirst();
    }
}
