package com.jp.springbatchpoc.service;

import com.jp.springbatchpoc.model.entity.League;
import com.jp.springbatchpoc.model.enums.Leagues;
import com.jp.springbatchpoc.repository.base.JPRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class LeagueService extends CachedEntityService<League> {

    public LeagueService(JPRepository<League, ?> repository) {
        super(repository);
    }

    public Optional<League> getLeagueFromLeagueCd(Leagues leagueCd) {
        return findAll().stream()
                .filter(league -> league.getAbbreviatedName().equalsIgnoreCase(leagueCd.name())
                        || league.getAbbreviatedName().equalsIgnoreCase(leagueCd.getNumberFireLeagueCode()))
                .findFirst();
    }
}
