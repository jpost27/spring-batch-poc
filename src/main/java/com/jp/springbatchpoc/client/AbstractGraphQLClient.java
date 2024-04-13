package com.jp.springbatchpoc.client;

import com.kobylynskyi.graphql.codegen.model.graphql.GraphQLOperationRequest;
import com.kobylynskyi.graphql.codegen.model.graphql.GraphQLRequest;
import com.kobylynskyi.graphql.codegen.model.graphql.GraphQLResponseProjection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.client.GraphQlClient;
import org.springframework.lang.NonNull;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractGraphQLClient {

    protected final GraphQlClient graphQlClient;

    public <T> Mono<T> query(
            GraphQLOperationRequest request, GraphQLResponseProjection projection, Class<T> returnType) {
        GraphQLRequest graphQLRequest = new GraphQLRequest(request, projection);
        return graphQlClient
                .document(graphQLRequest.toQueryString())
                .retrieve(request.getOperationName())
                .toEntity(returnType);
    }

    public @NonNull <T> Mono<List<T>> queryMany(
            GraphQLOperationRequest request, GraphQLResponseProjection projection, Class<T> returnType) {
        GraphQLRequest graphQLRequest = new GraphQLRequest(request, projection);
        return graphQlClient
                .document(graphQLRequest.toQueryString())
                .retrieve(request.getOperationName())
                .toEntityList(returnType);
    }

}
