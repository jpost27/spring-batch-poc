package com.jp.springbatchpoc.batch.reader;

import com.jp.springbatchpoc.model.dto.TeamIdentifier;
import com.jp.springbatchpoc.model.enums.Leagues;
import com.jp.springbatchpoc.service.TeamIdentifierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.util.Iterator;
import java.util.List;

/**
 * Given a leagueCd, this reader will query all teams of that league from almanac and read out their TeamIdentifiers one at a time
 */
@Slf4j
@RequiredArgsConstructor
public class AlmanacTeamIdentifiersReader implements ItemReader<TeamIdentifier> {

    private final TeamIdentifierService teamIdentifierService;
    @NonNull
    private final Leagues leagueCd;
    private Iterator<TeamIdentifier> teamDataIterator;

    @Override
    public TeamIdentifier read() {
        if (teamDataIterator == null) {
            Assert.notNull(leagueCd, "leagueCd cannot be null.");
            final List<TeamIdentifier> teamIdentifiers = teamIdentifierService.allTeamIdentifiersForLeague(leagueCd).blockOptional().orElse(List.of());
            teamDataIterator = teamIdentifiers.iterator();
        }
        if (teamDataIterator.hasNext()) {
            return teamDataIterator.next();
        } else {
            teamDataIterator = null;
            return null;
        }
    }

}
