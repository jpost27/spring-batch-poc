package com.jp.springbatchpoc.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.NonNull;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
public enum LeagueCd {
    MLB("mlb", "MLB", "51"),
    NBA("nba", "NBA", "62"),
    NCAAFB("ncaafb", "NCAAF", "64"),
    NCAAMB("ncaamb", "NCAAB", "63"),
    NFL("nfl", "NFL", "11"),
    GOLF("golf", "", "65"); // almanac competition ID 65 is PGA-specific

    private final String league;

    @Getter
    private final String numberFireLeagueCode;
    /*
    FanDuel competition ID is NOT associated with sportsbook (SCAN/SMP) Competitions
    */
    @Getter
    private final String fanDuelCompetitionId;

    @Override
    public String toString() {
        return league;
    }

    public static Optional<LeagueCd> fromString(@NonNull String fromString) {
        return Arrays.stream(LeagueCd.values())
                .filter(leagueCd ->
                        leagueCd.name().equalsIgnoreCase(fromString) || leagueCd.league.equalsIgnoreCase(fromString))
                .findFirst();
    }
}
