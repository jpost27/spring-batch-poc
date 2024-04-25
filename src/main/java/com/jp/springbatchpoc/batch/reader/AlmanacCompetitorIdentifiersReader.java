package com.jp.springbatchpoc.batch.reader;

import com.jp.springbatchpoc.model.dto.CompetitorIdentifier;
import com.jp.springbatchpoc.model.dto.TeamIdentifier;
import com.jp.springbatchpoc.model.enums.Leagues;
import com.jp.springbatchpoc.service.CompetitorIdentifierService;
import com.jp.springbatchpoc.service.TeamIdentifierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Given a leagueCd, this reader will query all teams of that league from almanac and read out their TeamIdentifiers one at a time
 */
@Slf4j
@RequiredArgsConstructor
public class AlmanacCompetitorIdentifiersReader implements ItemReader<CompetitorIdentifier> {

    private final TeamIdentifierService teamIdentifierService;
    private final CompetitorIdentifierService playerIdentifierService;
    @NonNull
    private final Leagues leagueCd;
    private Iterator<TeamIdentifier> teamIdentifierIterator;
    private Iterator<CompetitorIdentifier> competitorIdentifierIterator;

    @Override
    public CompetitorIdentifier read() {
        if (teamIdentifierIterator == null) {
            Assert.notNull(leagueCd, "leagueCd cannot be null.");
            final List<TeamIdentifier> teamIdentifiers = teamIdentifierService.allTeamIdentifiersForLeague(leagueCd).blockOptional().orElse(List.of());
            teamIdentifierIterator = teamIdentifiers.iterator();
        }
        if (competitorIdentifierIterator == null || !competitorIdentifierIterator.hasNext()) {
            // Out of players for current team. We need to look up the players for the next team and start returning that roster
            if (teamIdentifierIterator.hasNext()) {
                TeamIdentifier teamIdentifier = teamIdentifierIterator.next();
                final List<CompetitorIdentifier> playerIdentifiers =
                        playerIdentifierService.getRosterFromFanDuelTeamIDs(Set.of(teamIdentifier.getFanDuelId()))
                                .blockOptional()
                                .map(map -> map.get(teamIdentifier.getFanDuelId()))
                                .orElse(List.of());
                competitorIdentifierIterator = playerIdentifiers.iterator();
                return competitorIdentifierIterator.next();
            }
            // No more teams or players to iterate through
            return null;
        } else {
            // Return next player on current team
            return competitorIdentifierIterator.next();
        }
    }

}
