package com.jp.springbatchpoc.service;

import com.jp.springbatchpoc.model.entity.League;
import com.jp.springbatchpoc.model.enums.Leagues;
import com.jp.springbatchpoc.repository.LeagueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LeagueService {

    private final LeagueRepository leagueRepository;
    private List<League> allLeagues;

    public List<League> getAllLeagues() {
        if (allLeagues == null || allLeagues.isEmpty()) {
            allLeagues = leagueRepository.findAll();
        }
        return allLeagues;
    }

    public Optional<League> getLeagueFromLeagueCd(Leagues leagueCd) {
        return getAllLeagues().stream()
                .filter(league -> league.getAbbreviatedName().equalsIgnoreCase(leagueCd.name())
                        || league.getAbbreviatedName().equalsIgnoreCase(leagueCd.getNumberFireLeagueCode()))
                .findFirst();
    }

}
