package com.jp.springbatchpoc.batch.tasklet;

import com.jp.springbatchpoc.model.entity.League;
import com.jp.springbatchpoc.model.entity.Sport;
import com.jp.springbatchpoc.repository.LeagueRepository;
import com.jp.springbatchpoc.repository.SportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.step.tasklet.CallableTaskletAdapter;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class SportsLeaguesPopulationTasklet extends CallableTaskletAdapter {

    private final Map<String, List<League>> sportsLeaguesMap;
    private final SportRepository sportsRepository;
    private final LeagueRepository leagueRepository;

    public SportsLeaguesPopulationTasklet(
            final Map<String, List<League>> sportsLeaguesMap,
            final SportRepository sportsRepository,
            final LeagueRepository leagueRepository) {
        super();
        this.sportsLeaguesMap = sportsLeaguesMap;
        this.sportsRepository = sportsRepository;
        this.leagueRepository = leagueRepository;
        this.setCallable(this::populateSportsAndLeagues);
    }

    public RepeatStatus populateSportsAndLeagues() {
        Map<String, Sport> sportsByName = sportsRepository.findAll()
                .stream()
                .collect(Collectors.toMap(
                        Sport::getName,
                        Function.identity()
                ));
        List<Sport> newSports = new LinkedList<>();
        sportsLeaguesMap.forEach((sportName, leagues) -> {
            Sport sport = sportsByName.get(sportName);
            sportsByName.remove(sportName);
            if (sport == null) {
                sport = new Sport();
                sport.setName(sportName);
                newSports.add(sport);
            }
        });
        sportsRepository.saveAll(newSports)
                .forEach(sport -> sportsByName.put(sport.getName(), sport));

        sportsLeaguesMap.forEach((key, value) -> value
                .forEach(league -> league.setSport(sportsByName.get(key))));
        List<League> persistedLeagues = leagueRepository.findAll();
        List<League> leaguesToBeCreated = sportsLeaguesMap.values().stream().flatMap(List::stream).collect(Collectors.toList());
        leaguesToBeCreated.removeIf(league -> persistedLeagues.stream().anyMatch(pLeague -> pLeague.getFullName().equals(league.getFullName())));
        leagueRepository.saveAll(leaguesToBeCreated);

        return RepeatStatus.FINISHED;
    }


}
