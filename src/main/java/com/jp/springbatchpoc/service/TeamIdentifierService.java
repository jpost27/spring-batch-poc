package com.jp.springbatchpoc.service;

import com.jp.springbatchpoc.client.almanac.AlmanacClient;
import com.jp.springbatchpoc.model.client.almanac.AlmanacCompetition;
import com.jp.springbatchpoc.model.client.almanac.AlmanacProvider;
import com.jp.springbatchpoc.model.client.almanac.AlmanacProviderId;
import com.jp.springbatchpoc.model.client.almanac.AlmanacProviderIdInput;
import com.jp.springbatchpoc.model.client.almanac.AlmanacProviderIds;
import com.jp.springbatchpoc.model.client.almanac.AlmanacTeam;
import com.jp.springbatchpoc.model.dto.TeamIdentifier;
import com.jp.springbatchpoc.model.enums.Leagues;
import com.jp.springbatchpoc.utils.MapUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamIdentifierService {

    private final AlmanacClient almanacClient;

    public Mono<Map<Integer, TeamIdentifier>> fromNumberFireIDs(@NonNull Leagues leagueCd, Set<Integer> ids) {
        return getTeamIdentifiersFromTeamIDs(
                AlmanacProvider.NUMBERFIRE, ids.stream().map(id -> toAlmanacNumberFireId(leagueCd, id)))
                .map(nfIdToTeamMap ->
                        MapUtils.mutateKeys(nfIdToTeamMap, (entry) -> extractNumberFireId(entry.getKey())));
    }

    public Mono<Map<String, TeamIdentifier>> fromSportRadarIDs(Set<String> ids) {
        return getTeamIdentifiersFromTeamIDs(AlmanacProvider.SPORTRADAR, ids.stream());
    }

    public Mono<Map<Integer, TeamIdentifier>> fromFanDuelIDs(Set<Integer> ids) {
        return getTeamIdentifiersFromTeamIDs(
                AlmanacProvider.FANDUEL,
                ids.stream().filter(Objects::nonNull).map(Object::toString))
                .map(teamIdMap -> MapUtils.mutateKeys(
                        teamIdMap,
                        (s) -> Optional.ofNullable(s).map(Map.Entry::getKey).map(Integer::valueOf)));
    }

    public Mono<Map<Long, TeamIdentifier>> fromSportsbookIDs(Set<Long> ids) {
        return getTeamIdentifiersFromTeamIDs(
                AlmanacProvider.FANDUEL_SPORTSBOOK,
                ids.stream().filter(Objects::nonNull).map(Object::toString))
                .map(teamIdMap -> MapUtils.mutateKeys(
                        teamIdMap,
                        (s) -> Optional.ofNullable(s).map(Map.Entry::getKey).map(Long::valueOf)));
    }

    public Mono<List<TeamIdentifier>> allTeamIdentifiersForLeague(@NonNull Leagues leagueCd) {
        return getAlmanacCompetition(leagueCd).map(almanacCompetition -> almanacCompetition.getTeams().stream()
                .map(this::teamIdentifierFromTeam)
                .toList());
    }

    private Mono<Map<String, TeamIdentifier>> getTeamIdentifiersFromTeamIDs(
            AlmanacProvider provider, Stream<String> idStream) {
        List<AlmanacProviderIdInput> providerIds = idStream.map(id -> new AlmanacProviderIdInput(id, provider))
                .collect(Collectors.toCollection(ArrayList::new));
        return almanacClient
                .teamsByProviderId(providerIds)
                .map(teams -> MapUtils.zipListsToMap(
                        providerIds,
                        teams.stream()
                                .map(almanacTeam -> Optional.ofNullable(almanacTeam)
                                        .map(this::teamIdentifierFromTeam)
                                        .orElse(null))
                                .toList()))
                .map(providerIdTeamMap ->
                        MapUtils.mutateKeys(providerIdTeamMap, entry -> Optional.ofNullable(entry.getKey())
                                .map(AlmanacProviderIdInput::getId)));
    }

    private Mono<AlmanacCompetition> getAlmanacCompetition(Leagues leagueCd) {
        return almanacClient.competition("o:" + leagueCd.getFanDuelCompetitionId());
    }

    private String toAlmanacNumberFireId(@NonNull Leagues leagueCd, @NonNull Integer id) {
        return leagueCd.toString().toUpperCase() + '_' + id;
    }

    private Optional<Integer> extractNumberFireId(@NonNull String id) {
        return Arrays.stream(id.split("_")).reduce((first, second) -> second).flatMap(nfIdAsString -> {
            try {
                return Optional.of(Integer.valueOf(nfIdAsString));
            } catch (NumberFormatException nfe) {
                log.warn("Caught NumberFormatException while trying to parse NF iD from String: {}", nfIdAsString);
                return Optional.empty();
            }
        });
    }

    private @NonNull TeamIdentifier teamIdentifierFromTeam(@NonNull AlmanacTeam almanacTeam) {
        AlmanacProviderIds providerIds = almanacTeam.getProviderIds();
        return new TeamIdentifier()
                .setFanDuelId(Optional.ofNullable(providerIds.getFanduel())
                        .map(AlmanacProviderId::getId)
                        .map(Integer::parseInt)
                        .orElse(null))
                .setSportsbookIds(providerIds.getFanduelSportsbook().stream()
                        .map(AlmanacProviderId::getId)
                        .map(Long::parseLong)
                        .collect(Collectors.toList()))
                .setSportRadarId(Optional.ofNullable(providerIds.getSportradar())
                        .map(AlmanacProviderId::getId)
                        .orElse(null))
                .setNumberFireId(Optional.ofNullable(providerIds.getNumberfire())
                        .map(AlmanacProviderId::getId)
                        .flatMap(this::extractNumberFireId)
                        .orElse(null))
                .setTeamName(almanacTeam.getName());
    }
}
