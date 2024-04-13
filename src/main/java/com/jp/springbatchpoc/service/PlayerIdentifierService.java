package com.jp.springbatchpoc.service;

import com.jp.springbatchpoc.client.almanac.AlmanacClient;
import com.jp.springbatchpoc.model.client.almanac.AlmanacCompetitor;
import com.jp.springbatchpoc.model.client.almanac.AlmanacProvider;
import com.jp.springbatchpoc.model.client.almanac.AlmanacProviderId;
import com.jp.springbatchpoc.model.client.almanac.AlmanacProviderIdInput;
import com.jp.springbatchpoc.model.client.almanac.AlmanacProviderIds;
import com.jp.springbatchpoc.model.client.almanac.AlmanacTeam;
import com.jp.springbatchpoc.model.dto.PlayerIdentifier;
import com.jp.springbatchpoc.model.enums.LeagueCd;
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
public class PlayerIdentifierService {

    private final AlmanacClient almanacClient;

    public Mono<Map<Integer, PlayerIdentifier>> fromNumberFireIDs(@NonNull LeagueCd leagueCd, Set<Integer> ids) {
        return getPlayerMappingsFromPlayerIDs(
                AlmanacProvider.NUMBERFIRE, ids.stream().map(id -> toAlmanacNumberFireId(leagueCd, id)))
                .map(nfIdToPlayerMap ->
                        MapUtils.mutateKeys(nfIdToPlayerMap, (entry) -> extractNumberFireId(entry.getKey())));
    }

    public Mono<Map<Integer, List<PlayerIdentifier>>> getRosterFromNumberFireTeamIDs(
            @NonNull LeagueCd leagueCd, Set<Integer> teamIds) {
        return getPlayerRostersForTeamIds(
                AlmanacProvider.NUMBERFIRE, teamIds.stream().map(id -> toAlmanacNumberFireId(leagueCd, id)))
                .map(nfIdToPlayerMap ->
                        MapUtils.mutateKeys(nfIdToPlayerMap, (entry) -> extractNumberFireId(entry.getKey())));
    }

    public Mono<Map<String, PlayerIdentifier>> fromSportRadarIDs(Set<String> ids) {
        return getPlayerMappingsFromPlayerIDs(AlmanacProvider.SPORTRADAR, ids.stream());
    }

    public Mono<Map<String, List<PlayerIdentifier>>> getRosterFromSportRadarTeamIDs(Set<String> teamIds) {
        return getPlayerRostersForTeamIds(AlmanacProvider.SPORTRADAR, teamIds.stream());
    }

    public Mono<Map<Integer, PlayerIdentifier>> fromFanDuelIDs(Set<Integer> ids) {
        return getPlayerMappingsFromPlayerIDs(
                AlmanacProvider.FANDUEL,
                ids.stream().filter(Objects::nonNull).map(Object::toString))
                .map(playerIdMap -> MapUtils.mutateKeys(
                        playerIdMap,
                        (s) -> Optional.ofNullable(s).map(Map.Entry::getKey).map(Integer::valueOf)));
    }

    public Mono<Map<Integer, List<PlayerIdentifier>>> getRosterFromFanDuelTeamIDs(Set<Integer> teamIds) {
        return getPlayerRostersForTeamIds(
                AlmanacProvider.FANDUEL,
                teamIds.stream().filter(Objects::nonNull).map(Object::toString))
                .map(playerIdMap -> MapUtils.mutateKeys(
                        playerIdMap,
                        (s) -> Optional.ofNullable(s).map(Map.Entry::getKey).map(Integer::valueOf)));
    }

    public Mono<Map<Long, PlayerIdentifier>> fromSportsbookIDs(Set<Long> ids) {
        return getPlayerMappingsFromPlayerIDs(
                AlmanacProvider.FANDUEL_SPORTSBOOK,
                ids.stream().filter(Objects::nonNull).map(Object::toString))
                .map(playerIdMap -> MapUtils.mutateKeys(
                        playerIdMap,
                        (s) -> Optional.ofNullable(s).map(Map.Entry::getKey).map(Long::valueOf)));
    }

    public Mono<Map<Long, List<PlayerIdentifier>>> getRosterFromSportsbookTeamIDs(Set<Long> teamIds) {
        return getPlayerRostersForTeamIds(
                AlmanacProvider.FANDUEL_SPORTSBOOK,
                teamIds.stream().filter(Objects::nonNull).map(Object::toString))
                .map(playerIdMap -> MapUtils.mutateKeys(
                        playerIdMap,
                        (s) -> Optional.ofNullable(s).map(Map.Entry::getKey).map(Long::valueOf)));
    }

    private Mono<Map<String, PlayerIdentifier>> getPlayerMappingsFromPlayerIDs(
            AlmanacProvider provider, Stream<String> idStream) {
        List<AlmanacProviderIdInput> providerIds = idStream.map(id -> new AlmanacProviderIdInput(id, provider))
                .collect(Collectors.toCollection(ArrayList::new));
        return almanacClient
                .competitorsByProviderId(providerIds)
                .map(competitors -> MapUtils.zipListsToMap(
                        providerIds,
                        competitors.stream()
                                .map(almanacCompetitor -> Optional.ofNullable(almanacCompetitor)
                                        .map(competitor -> playerMappingFromCompetitor(
                                                competitor,
                                                Optional.ofNullable(competitor.getTeam())
                                                        .map(AlmanacTeam::getProviderIds)
                                                        .orElse(null)))
                                        .orElse(null))
                                .toList()))
                .map(providerIdCompetitorMap ->
                        MapUtils.mutateKeys(providerIdCompetitorMap, entry -> Optional.ofNullable(entry.getKey())
                                .map(AlmanacProviderIdInput::getId)));
    }

    private Mono<Map<String, List<PlayerIdentifier>>> getPlayerRostersForTeamIds(
            AlmanacProvider almanacProvider, Stream<String> providerTeamIds) {

        return getAlmanacTeams(almanacProvider, providerTeamIds)
                .flatMapIterable(Map::entrySet)
                .mapNotNull(almanacProviderIdInputAlmanacTeamEntry -> Optional.ofNullable(
                                almanacProviderIdInputAlmanacTeamEntry.getValue())
                        .map(almanacTeam -> Map.entry(
                                almanacProviderIdInputAlmanacTeamEntry.getKey().getId(),
                                almanacTeam.getCompetitors().stream()
                                        .filter(Objects::nonNull)
                                        .map(competitor -> playerMappingFromCompetitor(
                                                competitor,
                                                almanacProviderIdInputAlmanacTeamEntry
                                                        .getValue()
                                                        .getProviderIds()))
                                        .toList()))
                        .orElse(null))
                .collectMap(Map.Entry::getKey, Map.Entry::getValue);
    }

    private Mono<Map<AlmanacProviderIdInput, AlmanacTeam>> getAlmanacTeams(
            AlmanacProvider almanacProvider, Stream<String> idStream) {
        final List<AlmanacProviderIdInput> providerIdInputs = idStream.filter(Objects::nonNull)
                .map(teamId -> new AlmanacProviderIdInput(teamId, almanacProvider))
                .collect(Collectors.toCollection(ArrayList::new));
        return almanacClient
                .teamsByProviderId(providerIdInputs)
                .map(almanacTeams -> MapUtils.zipListsToMap(providerIdInputs, almanacTeams));
    }

    private String toAlmanacNumberFireId(@NonNull LeagueCd leagueCd, @NonNull Integer id) {
        if (leagueCd.equals(LeagueCd.GOLF)) {
            return "PGA_" + id;
        }
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

    private @NonNull PlayerIdentifier playerMappingFromCompetitor(
            @NonNull AlmanacCompetitor competitor, AlmanacProviderIds teamProviderIds) {
        AlmanacProviderIds providerIds = competitor.getProviderIds();
        return new PlayerIdentifier()
                .setFanDuelId(Optional.ofNullable(providerIds.getFanduel())
                        .map(AlmanacProviderId::getId)
                        .map(Integer::parseInt)
                        .orElse(null))
                .setTeamFanDuelId(Optional.ofNullable(teamProviderIds)
                        .map(AlmanacProviderIds::getFanduel)
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
                .setTeamSportBookIds(
                        Optional.ofNullable(teamProviderIds).map(AlmanacProviderIds::getFanduelSportsbook).stream()
                                .flatMap(List::stream)
                                .map(AlmanacProviderId::getId)
                                .collect(Collectors.toList()))
                .setTeamSportRadarId(Optional.ofNullable(teamProviderIds)
                        .map(AlmanacProviderIds::getSportradar)
                        .map(AlmanacProviderId::getId)
                        .orElse(null))
                .setNumberFireId(Optional.ofNullable(providerIds.getNumberfire())
                        .map(AlmanacProviderId::getId)
                        .flatMap(this::extractNumberFireId)
                        .orElse(null))
                .setTeamNumberFireId(Optional.ofNullable(teamProviderIds)
                        .map(AlmanacProviderIds::getNumberfire)
                        .map(AlmanacProviderId::getId)
                        .flatMap(this::extractNumberFireId)
                        .orElse(null))
                .setPlayerName(competitor.getFirstNames() + " " + competitor.getLastName());
    }
}
