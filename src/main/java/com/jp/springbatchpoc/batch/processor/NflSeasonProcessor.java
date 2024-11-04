package com.jp.springbatchpoc.batch.processor;

import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasons.SrNflV7SeasonsSeason;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasons.SrNflV7SeasonsType;
import com.jp.springbatchpoc.model.entity.League;
import com.jp.springbatchpoc.model.entity.Season;
import com.jp.springbatchpoc.model.enums.Leagues;
import com.jp.springbatchpoc.model.enums.SeasonTypes;
import com.jp.springbatchpoc.service.LeagueService;
import com.jp.springbatchpoc.service.SeasonTypeService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;

@RequiredArgsConstructor
public class NflSeasonProcessor implements ItemProcessor<SrNflV7SeasonsSeason, Season> {

    private final LeagueService leagueService;
    private final SeasonTypeService seasonService;

    @Override
    public Season process(SrNflV7SeasonsSeason item) throws Exception {
        League league = leagueService.getLeagueFromLeagueCd(Leagues.NFL).orElseThrow();
        Season season = new Season();
        season.setYear(item.getYear().orElseThrow());
        SeasonTypes seasonType =
                switch (item.getType().flatMap(SrNflV7SeasonsType::getCode).orElseThrow()) {
                    case "REG" -> SeasonTypes.REGULAR;
                    case "PRE" -> SeasonTypes.PRE;
                    case "PST" -> SeasonTypes.POST;
                    default -> throw new IllegalArgumentException("Invalid season type code");
                };
        seasonService.findAll().stream()
                .filter(seasonType1 -> seasonType1.getSeasonTypeCode().equals(seasonType.getTypeCode()))
                .findFirst()
                .ifPresent(season::setSeasonType);
        season.setLeague(league);
        season.setStartDate(LocalDate.parse(item.getStartDate().orElseThrow()));
        season.setEndDate(LocalDate.parse(item.getEndDate().orElseThrow()));

        return season;
    }
}
