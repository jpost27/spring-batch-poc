package com.jp.springbatchpoc.batch.tasklet;

import com.jp.springbatchpoc.model.entity.League;
import com.jp.springbatchpoc.model.entity.Sport;
import com.jp.springbatchpoc.model.entity.TeamAssociationType;
import com.jp.springbatchpoc.model.entity.TeamColorType;
import com.jp.springbatchpoc.model.enums.Leagues;
import com.jp.springbatchpoc.model.enums.Sports;
import com.jp.springbatchpoc.model.enums.TeamAssociationTypes;
import com.jp.springbatchpoc.model.enums.TeamColorTypes;
import com.jp.springbatchpoc.repository.LeagueRepository;
import com.jp.springbatchpoc.repository.SportRepository;
import com.jp.springbatchpoc.repository.TeamAssociationTypeRepository;
import com.jp.springbatchpoc.repository.TeamColorTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.step.tasklet.CallableTaskletAdapter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class EnumsPopulationTasklet extends CallableTaskletAdapter {

    private final SportRepository sportsRepository;
    private final LeagueRepository leagueRepository;
    private final TeamAssociationTypeRepository teamAssociationTypeRepository;
    private final TeamColorTypeRepository teamColorTypeRepository;

    public EnumsPopulationTasklet(
            final SportRepository sportsRepository,
            final LeagueRepository leagueRepository,
            final TeamAssociationTypeRepository teamAssociationTypeRepository,
            final TeamColorTypeRepository teamColorTypeRepository) {
        super();
        this.sportsRepository = sportsRepository;
        this.leagueRepository = leagueRepository;
        this.teamAssociationTypeRepository = teamAssociationTypeRepository;
        this.teamColorTypeRepository = teamColorTypeRepository;
        this.setCallable(this::populateAllEnums);
    }

    private RepeatStatus populateAllEnums() {
        populateSports();
        populateLeagues();
        populateTeamAssociationCodes();
        populateTeamColorTypes();
        return RepeatStatus.FINISHED;
    }

    private void populateSports() {
        populateEnum(
                Sports.values(),
                sportsRepository,
                Sport::getName,
                Sports::getSportName,
                typeEnum -> {
                    Sport type = new Sport();
                    type.setName(typeEnum.getSportName());
                    return type;
                });
    }

    private void populateLeagues() {
        Map<Sports, Sport> sportsByEnum = sportsRepository.findAll()
                .stream()
                .filter(sport -> Sports.fromSport(sport).isPresent())
                .collect(Collectors.toMap(
                        sport -> Sports.fromSport(sport).orElseThrow(),
                        Function.identity()
                ));
        populateEnum(
                Leagues.values(),
                leagueRepository,
                League::getFullName,
                Leagues::getFullName,
                typeEnum -> {
                    League league = new League();
                    league.setFullName(typeEnum.getFullName());
                    league.setAbbreviatedName(typeEnum.getAbbreviatedName());
                    league.setSport(sportsByEnum.get(typeEnum.getSport()));
                    return league;
                }
        );
    }

    private void populateTeamAssociationCodes() {
        populateEnum(
                TeamAssociationTypes.values(),
                teamAssociationTypeRepository,
                TeamAssociationType::getTeamAssociationTypeCode,
                TeamAssociationTypes::getAssociationName,
                typeEnum -> {
                    TeamAssociationType type = new TeamAssociationType();
                    type.setTeamAssociationTypeCode(typeEnum.getAssociationName());
                    return type;
                });
    }

    private void populateTeamColorTypes() {
        populateEnum(
                TeamColorTypes.values(),
                teamColorTypeRepository,
                TeamColorType::getTeamColorTypeCode,
                TeamColorTypes::getTypeName,
                typeEnum -> {
                    TeamColorType type = new TeamColorType();
                    type.setTeamColorTypeCode(typeEnum.getTypeName());
                    return type;
                });
    }

    private <E, T, I> void populateEnum(
            E[] values,
            ListCrudRepository<T, ?> repository,
            Function<T, I> entityIdentityExtractor,
            Function<E, I> enumIdentityExtractor,
            Function<E, T> enumToEntityFn) {
        Map<I, T> typesByIdentifier = repository.findAll()
                .stream()
                .collect(Collectors.toMap(
                        entityIdentityExtractor,
                        Function.identity()
                ));
        List<T> newTypes = new LinkedList<>();
        Arrays.stream(values).forEach((typeEnum) -> {
            T type = typesByIdentifier.remove(enumIdentityExtractor.apply(typeEnum));
            if (type == null) {
                type = enumToEntityFn.apply(typeEnum);
                newTypes.add(type);
            }
        });
        if (!typesByIdentifier.isEmpty()) {
            typesByIdentifier.forEach((identifier, type) ->
                    log.error("Detected untracked enum: {}. Create a value for this in {}",
                            type,
                            Arrays.stream(values)
                                    .findAny()
                                    .map(e -> e.getClass().getTypeName())
                                    .orElse(null)));
            log.warn("Unable to update enums for entity: {}. Please resolve the errors above to allow updates.",
                    typesByIdentifier.values()
                            .stream()
                            .findAny()
                            .map(type -> type.getClass().getTypeName()).orElse(null));
        } else {
            repository.saveAll(newTypes);
        }
    }

}
