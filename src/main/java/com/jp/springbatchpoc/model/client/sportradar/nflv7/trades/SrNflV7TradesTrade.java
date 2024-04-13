package com.jp.springbatchpoc.model.client.sportradar.nflv7.trades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.Long;
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
public class SrNflV7TradesTrade {
    @JsonProperty("complete")
    private Boolean complete;

    @JsonProperty("id")
    private String id;

    @JsonProperty("sequence")
    private Long sequence;

    @JsonProperty("transactions")
    private List<SrNflV7TradesTransaction> transactions;

    public Optional<Boolean> getComplete() {
        return Optional.ofNullable(complete);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<Long> getSequence() {
        return Optional.ofNullable(sequence);
    }

    public List<SrNflV7TradesTransaction> getTransactions() {
        return Optional.ofNullable(transactions).orElse(Collections.emptyList());
    }
}
