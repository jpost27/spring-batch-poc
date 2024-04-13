package com.jp.springbatchpoc.model.client.sportradar.nflv7.trades;

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
public class SrNflV7TradesTransaction {
    @JsonProperty("from_team")
    private SrNflV7TradesFromTeam fromTeam;

    @JsonProperty("id")
    private String id;

    @JsonProperty("items")
    private List<SrNflV7TradesItem> items;

    @JsonProperty("to_team")
    private SrNflV7TradesToTeam toTeam;

    public Optional<SrNflV7TradesFromTeam> getFromTeam() {
        return Optional.ofNullable(fromTeam);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public List<SrNflV7TradesItem> getItems() {
        return Optional.ofNullable(items).orElse(Collections.emptyList());
    }

    public Optional<SrNflV7TradesToTeam> getToTeam() {
        return Optional.ofNullable(toTeam);
    }
}
