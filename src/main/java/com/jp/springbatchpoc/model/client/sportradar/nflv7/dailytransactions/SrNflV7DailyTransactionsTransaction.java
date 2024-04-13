package com.jp.springbatchpoc.model.client.sportradar.nflv7.dailytransactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Integer;
import java.lang.String;
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
public class SrNflV7DailyTransactionsTransaction {
    @JsonProperty("desc")
    private String desc;

    @JsonProperty("effective_date")
    private String effectiveDate;

    @JsonProperty("from_team")
    private SrNflV7DailyTransactionsFromTeam fromTeam;

    @JsonProperty("id")
    private String id;

    @JsonProperty("last_modified")
    private String lastModified;

    @JsonProperty("status_after")
    private String statusAfter;

    @JsonProperty("status_before")
    private String statusBefore;

    @JsonProperty("to_team")
    private SrNflV7DailyTransactionsToTeam toTeam;

    @JsonProperty("transaction_code")
    private String transactionCode;

    @JsonProperty("transaction_type")
    private String transactionType;

    @JsonProperty("transaction_year")
    private Integer transactionYear;

    public Optional<String> getDesc() {
        return Optional.ofNullable(desc);
    }

    public Optional<String> getEffectiveDate() {
        return Optional.ofNullable(effectiveDate);
    }

    public Optional<SrNflV7DailyTransactionsFromTeam> getFromTeam() {
        return Optional.ofNullable(fromTeam);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<String> getLastModified() {
        return Optional.ofNullable(lastModified);
    }

    public Optional<String> getStatusAfter() {
        return Optional.ofNullable(statusAfter);
    }

    public Optional<String> getStatusBefore() {
        return Optional.ofNullable(statusBefore);
    }

    public Optional<SrNflV7DailyTransactionsToTeam> getToTeam() {
        return Optional.ofNullable(toTeam);
    }

    public Optional<String> getTransactionCode() {
        return Optional.ofNullable(transactionCode);
    }

    public Optional<String> getTransactionType() {
        return Optional.ofNullable(transactionType);
    }

    public Optional<Integer> getTransactionYear() {
        return Optional.ofNullable(transactionYear);
    }
}
