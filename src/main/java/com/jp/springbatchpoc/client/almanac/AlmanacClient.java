package com.jp.springbatchpoc.client.almanac;

import com.jp.springbatchpoc.model.client.almanac.AlmanacCompetition;
import com.jp.springbatchpoc.model.client.almanac.AlmanacCompetitor;
import com.jp.springbatchpoc.model.client.almanac.AlmanacNode;
import com.jp.springbatchpoc.model.client.almanac.AlmanacProviderIdInput;
import com.jp.springbatchpoc.model.client.almanac.AlmanacTeam;
import org.springframework.lang.NonNull;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AlmanacClient extends AlmanacQueryResolver {

    Mono<AlmanacCompetition> competition(@NonNull String id);

    @NonNull
    Mono<List<AlmanacCompetition>> competitions(@NonNull List<String> ids);

    Mono<AlmanacCompetitor> competitor(@NonNull String id);

    Mono<AlmanacCompetitor> competitorByProviderId(@NonNull AlmanacProviderIdInput providerIdInput);

    /**
     * Queries Almanac for multiple competitors. The list returned will be in the same order as the
     * list of IDs input and will contain a null placeholder for any invalid IDs. competitor
     *
     * @param ids
     * @return Mono containing a List of competitors
     */
    @NonNull
    Mono<List<AlmanacCompetitor>> competitors(@NonNull List<String> ids);

    /**
     * Queries Almanac for multiple competitors. The list returned will be in the same order as the
     * list of IDs input and will contain a null placeholder for any invalid IDs.
     *
     * @param providerIds
     * @return Mono containing a List of competitors
     */
    @NonNull
    Mono<List<AlmanacCompetitor>> competitorsByProviderId(@NonNull List<AlmanacProviderIdInput> providerIds);

    Mono<AlmanacNode> node(@NonNull String id);

    @NonNull
    Mono<List<AlmanacNode>> nodes(@NonNull List<String> ids);

    Mono<AlmanacTeam> team(@NonNull String id);

    Mono<AlmanacTeam> teamByProviderId(@NonNull AlmanacProviderIdInput providerId);

    /**
     * Queries Almanac for multiple teams. The list returned will be in the same order as the list
     * of IDs input and will contain a null placeholder for any invalid IDs.
     *
     * @param ids
     * @return Mono containing a List of teams
     */
    @NonNull
    Mono<List<AlmanacTeam>> teams(@NonNull List<String> ids);

    /**
     * Queries Almanac for multiple teams. The list returned will be in the same order as the list
     * of IDs input and will contain a null placeholder for any invalid IDs.
     *
     * @param providerIds
     * @return Mono containing a List of teams
     */
    @NonNull
    Mono<List<AlmanacTeam>> teamsByProviderId(@NonNull List<AlmanacProviderIdInput> providerIds);
}
