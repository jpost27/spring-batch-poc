package com.jp.springbatchpoc.model.client.sportradar.nflv7.dailytransactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.String;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.annotation.processing.Generated;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Setter
@Accessors(
        chain = true
)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@EqualsAndHashCode
@ToString
@Generated("fanduel-model-generator")
public class SrNflV7DailyTransactionsPlayer {
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("id")
    private String id;

    @JsonProperty("jersey")
    private String jersey;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("name")
    private String name;

    @JsonProperty("position")
    private String position;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("transactions")
    private List<SrNflV7DailyTransactionsTransaction> transactions;

    public Optional<String> getFirstName() {
        return Optional.ofNullable(firstName);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<String> getJersey() {
        return Optional.ofNullable(jersey);
    }

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }

    public List<SrNflV7DailyTransactionsTransaction> getTransactions() {
        return Optional.ofNullable(transactions).orElse(Collections.emptyList());
    }
}
