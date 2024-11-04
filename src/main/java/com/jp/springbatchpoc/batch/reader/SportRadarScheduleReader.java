package com.jp.springbatchpoc.batch.reader;

import com.jp.springbatchpoc.client.sportradar.nflv7.SportRadarNflV7Client;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonschedule.SrNflV7SeasonScheduleGame;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonschedule.SrNflV7SeasonScheduleResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonschedule.SrNflV7SeasonScheduleWeek;
import com.jp.springbatchpoc.model.entity.Season;
import com.jp.springbatchpoc.service.SeasonService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

@RequiredArgsConstructor
public class SportRadarScheduleReader
        implements ItemReader<SportRadarScheduleReader.SportRadarWeekAndGameWithNflSeason> {

    private final SeasonService seasonService;
    private final SportRadarNflV7Client sportRadarNflV7Client;
    private List<SportRadarWeekAndGameWithNflSeason> games;
    private List<Season> seasons;

    @Override
    public SportRadarWeekAndGameWithNflSeason read()
            throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        if (seasons == null) {
            seasons = seasonService.findAll();
        }

        if (games == null || games.isEmpty()) {
            if (seasons.isEmpty()) {
                return null;
            }
            Season season = seasons.remove(0);
            String seasonType =
                    switch (season.getSeasonType().getSeasonTypeCode()) {
                        case "REGULAR" -> "REG";
                        case "PRE" -> "PRE";
                        case "POST" -> "PST";
                        default -> throw new IllegalArgumentException("Invalid season type code");
                    };
            games = sportRadarNflV7Client
                    .getSeasonSchedule(season.getYear(), seasonType)
                    .blockOptional()
                    .map((SrNflV7SeasonScheduleResponse srSeason) -> srSeason.getWeeks().stream()
                            .flatMap((SrNflV7SeasonScheduleWeek week) -> week.getGames().stream()
                                    .flatMap(srGame ->
                                            Stream.of(new SportRadarWeekAndGameWithNflSeason(season, week, srGame)))))
                    .map(Stream::toList)
                    .map(ArrayList::new)
                    .orElseThrow();
        }

        return games.isEmpty() ? null : games.remove(0);
    }

    public record SportRadarWeekAndGameWithNflSeason(
            Season season, SrNflV7SeasonScheduleWeek seasonType, SrNflV7SeasonScheduleGame game) {}
}
