package com.jp.springbatchpoc.client.almanac;

import com.jp.springbatchpoc.client.AbstractGraphQLClient;
import com.jp.springbatchpoc.model.client.almanac.AlmanacCompetition;
import com.jp.springbatchpoc.model.client.almanac.AlmanacCompetitor;
import com.jp.springbatchpoc.model.client.almanac.AlmanacFixture;
import com.jp.springbatchpoc.model.client.almanac.AlmanacNode;
import com.jp.springbatchpoc.model.client.almanac.AlmanacProviderIdInput;
import com.jp.springbatchpoc.model.client.almanac.AlmanacTeam;
import com.jp.springbatchpoc.model.client.almanac.CompetitionQueryRequest;
import com.jp.springbatchpoc.model.client.almanac.CompetitionResponseProjection;
import com.jp.springbatchpoc.model.client.almanac.CompetitionsQueryRequest;
import com.jp.springbatchpoc.model.client.almanac.CompetitorByProviderIdQueryRequest;
import com.jp.springbatchpoc.model.client.almanac.CompetitorQueryRequest;
import com.jp.springbatchpoc.model.client.almanac.CompetitorResponseProjection;
import com.jp.springbatchpoc.model.client.almanac.CompetitorsByProviderIdQueryRequest;
import com.jp.springbatchpoc.model.client.almanac.CompetitorsQueryRequest;
import com.jp.springbatchpoc.model.client.almanac.FixtureByProviderIdQueryRequest;
import com.jp.springbatchpoc.model.client.almanac.FixtureQueryRequest;
import com.jp.springbatchpoc.model.client.almanac.FixtureResponseProjection;
import com.jp.springbatchpoc.model.client.almanac.FixturesByProviderIdQueryRequest;
import com.jp.springbatchpoc.model.client.almanac.FixturesQueryRequest;
import com.jp.springbatchpoc.model.client.almanac.NodeQueryRequest;
import com.jp.springbatchpoc.model.client.almanac.NodeResponseProjection;
import com.jp.springbatchpoc.model.client.almanac.NodesQueryRequest;
import com.jp.springbatchpoc.model.client.almanac.ProviderIdResponseProjection;
import com.jp.springbatchpoc.model.client.almanac.ProviderIdsResponseProjection;
import com.jp.springbatchpoc.model.client.almanac.TeamByProviderIdQueryRequest;
import com.jp.springbatchpoc.model.client.almanac.TeamQueryRequest;
import com.jp.springbatchpoc.model.client.almanac.TeamResponseProjection;
import com.jp.springbatchpoc.model.client.almanac.TeamsByProviderIdQueryRequest;
import com.jp.springbatchpoc.model.client.almanac.TeamsQueryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.graphql.client.GraphQlClient;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Slf4j
public class AlmanacClientImpl extends AbstractGraphQLClient implements AlmanacClient {

    public AlmanacClientImpl(@Qualifier("almanacGraphQlClient") GraphQlClient graphQlClient) {
        super(graphQlClient);
    }

    @Override
    public Mono<AlmanacCompetition> competition(@NonNull String id) {
        final CompetitionQueryRequest request =
                CompetitionQueryRequest.builder().setId(id).build();

        final CompetitionResponseProjection projection =
                getDefaultCompetitionResponseProjection().teams(getDefaultTeamResponseProjection());
        return query(request, projection, AlmanacCompetition.class);
    }

    @Override
    public @NonNull Mono<List<AlmanacCompetition>> competitions(@NonNull List<String> ids) {
        final CompetitionsQueryRequest request =
                CompetitionsQueryRequest.builder().setIds(ids).build();

        final CompetitionResponseProjection projection =
                getDefaultCompetitionResponseProjection().teams(getDefaultTeamResponseProjection());
        return queryMany(request, projection, AlmanacCompetition.class);
    }

    @Override
    public Mono<AlmanacCompetitor> competitor(@NonNull String id) {
        final CompetitorQueryRequest request =
                CompetitorQueryRequest.builder().setId(id).build();

        final CompetitorResponseProjection projection = getDefaultCompetitorResponseProjection()
                .team(new TeamResponseProjection().providerIds(getDefaultProviderIdsResponseProjection()));
        return query(request, projection, AlmanacCompetitor.class);
    }

    @Override
    public Mono<AlmanacCompetitor> competitorByProviderId(@NonNull AlmanacProviderIdInput providerIdInput) {
        final CompetitorByProviderIdQueryRequest request = CompetitorByProviderIdQueryRequest.builder()
                .setProviderId(providerIdInput)
                .build();

        final CompetitorResponseProjection projection = getDefaultCompetitorResponseProjection()
                .team(new TeamResponseProjection().providerIds(getDefaultProviderIdsResponseProjection()));
        return query(request, projection, AlmanacCompetitor.class);
    }

    @Override
    public @NonNull Mono<List<AlmanacCompetitor>> competitors(@NonNull List<String> ids) {
        final CompetitorsQueryRequest request =
                CompetitorsQueryRequest.builder().setIds(ids).build();

        final CompetitorResponseProjection projection = getDefaultCompetitorResponseProjection()
                .team(new TeamResponseProjection().providerIds(getDefaultProviderIdsResponseProjection()));
        return queryMany(request, projection, AlmanacCompetitor.class);
    }

    @Override
    public @NonNull Mono<List<AlmanacCompetitor>> competitorsByProviderId(
            @NonNull List<AlmanacProviderIdInput> providerIds) {
        final CompetitorsByProviderIdQueryRequest request = CompetitorsByProviderIdQueryRequest.builder()
                .setProviderIds(providerIds)
                .build();

        final CompetitorResponseProjection projection = getDefaultCompetitorResponseProjection()
                .team(new TeamResponseProjection().providerIds(getDefaultProviderIdsResponseProjection()));
        return queryMany(request, projection, AlmanacCompetitor.class);
    }

    @Override
    public Mono<AlmanacNode> node(@NonNull String id) {
        final NodeQueryRequest request = NodeQueryRequest.builder().setId(id).build();

        final NodeResponseProjection projection = new NodeResponseProjection().all$(3);
        return query(request, projection, AlmanacNode.class);
    }

    @Override
    public @NonNull Mono<List<AlmanacNode>> nodes(@NonNull List<String> ids) {
        final NodesQueryRequest request =
                NodesQueryRequest.builder().setIds(ids).build();

        final NodeResponseProjection projection = new NodeResponseProjection().all$(3);
        return queryMany(request, projection, AlmanacNode.class);
    }

    @Override
    public Mono<AlmanacTeam> team(@NonNull String id) {
        final TeamQueryRequest request = TeamQueryRequest.builder().setId(id).build();

        final TeamResponseProjection projection =
                getDefaultTeamResponseProjection().competitors(getDefaultCompetitorResponseProjection());
        return query(request, projection, AlmanacTeam.class);
    }

    @Override
    public Mono<AlmanacTeam> teamByProviderId(@NonNull AlmanacProviderIdInput providerId) {
        final TeamByProviderIdQueryRequest request =
                TeamByProviderIdQueryRequest.builder().setProviderId(providerId).build();

        final TeamResponseProjection projection =
                getDefaultTeamResponseProjection().competitors(getDefaultCompetitorResponseProjection());
        return query(request, projection, AlmanacTeam.class);
    }

    @Override
    public @NonNull Mono<List<AlmanacTeam>> teams(@NonNull List<String> ids) {
        final TeamsQueryRequest request =
                TeamsQueryRequest.builder().setIds(ids).build();

        final TeamResponseProjection projection =
                getDefaultTeamResponseProjection().competitors(getDefaultCompetitorResponseProjection());
        return queryMany(request, projection, AlmanacTeam.class);
    }

    @Override
    public @NonNull Mono<List<AlmanacTeam>> teamsByProviderId(@NonNull List<AlmanacProviderIdInput> providerIds) {
        final TeamsByProviderIdQueryRequest request = TeamsByProviderIdQueryRequest.builder()
                .setProviderIds(providerIds)
                .build();

        final TeamResponseProjection projection =
                getDefaultTeamResponseProjection().competitors(getDefaultCompetitorResponseProjection());
        return queryMany(request, projection, AlmanacTeam.class);
    }

    @Override
    public Mono<AlmanacFixture> fixture(@NonNull String id) {
        final FixtureQueryRequest request =
                FixtureQueryRequest.builder().setId(id).build();
        final FixtureResponseProjection projection = getDefaultFixtureResponseProjection();
        return query(request, projection, AlmanacFixture.class);
    }

    @Override
    public Mono<AlmanacFixture> fixtureByProviderId(@NonNull AlmanacProviderIdInput providerId) {
        final FixtureByProviderIdQueryRequest request = FixtureByProviderIdQueryRequest.builder()
                .setProviderId(providerId)
                .build();
        final FixtureResponseProjection projection = getDefaultFixtureResponseProjection();
        return query(request, projection, AlmanacFixture.class);
    }

    @Override
    public @NonNull Mono<List<AlmanacFixture>> fixtures(@NonNull List<String> ids) {
        final FixturesQueryRequest request =
                FixturesQueryRequest.builder().setIds(ids).build();
        final FixtureResponseProjection projection = getDefaultFixtureResponseProjection();
        return queryMany(request, projection, AlmanacFixture.class);
    }

    @Override
    public @NonNull Mono<List<AlmanacFixture>> fixturesByProviderId(@NonNull List<AlmanacProviderIdInput> providerIds) {
        final FixturesByProviderIdQueryRequest request = FixturesByProviderIdQueryRequest.builder()
                .setProviderIds(providerIds)
                .build();
        final FixtureResponseProjection projection = getDefaultFixtureResponseProjection();
        return queryMany(request, projection, AlmanacFixture.class);
    }

    private CompetitionResponseProjection getDefaultCompetitionResponseProjection() {
        return new CompetitionResponseProjection()
                .id()
                .name()
                .slug()
                .providerIds(getDefaultProviderIdsResponseProjection());
    }

    private CompetitorResponseProjection getDefaultCompetitorResponseProjection() {
        return new CompetitorResponseProjection()
                .providerIds(getDefaultProviderIdsResponseProjection())
                .firstNames()
                .lastName()
                .id();
    }

    private TeamResponseProjection getDefaultTeamResponseProjection() {
        return new TeamResponseProjection().id().name().providerIds(getDefaultProviderIdsResponseProjection());
    }

    private ProviderIdsResponseProjection getDefaultProviderIdsResponseProjection() {
        return new ProviderIdsResponseProjection()
                .fanduel(new ProviderIdResponseProjection().all$())
                .fanduelSportsbook(new ProviderIdResponseProjection().all$())
                .sportradar(new ProviderIdResponseProjection().all$())
                .numberfire(new ProviderIdResponseProjection().all$())
                .sportsdataio(new ProviderIdResponseProjection().all$());
    }

    private FixtureResponseProjection getDefaultFixtureResponseProjection() {
        return new FixtureResponseProjection()
                .typename()
                .fixtureDate()
                .fixtureType()
                .broadcastCode()
                .broadcastName()
                .nationalBroadcastCode()
                .nationalBroadcastName()
                .season()
                .seasonWeek()
                .status()
                .providerIds(getDefaultProviderIdsResponseProjection())
                .competitors(getDefaultCompetitorResponseProjection())
                .competition(getDefaultCompetitionResponseProjection());
    }
}
