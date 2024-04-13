package com.jp.springbatchpoc.model.client.sportradar.nflv7.trades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SrNflV7TradesItem {
    @JsonProperty("future_pick")
    private SrNflV7TradesFuturePick futurePick;

    @JsonProperty("id")
    private String id;

    @JsonProperty("pick")
    private SrNflV7TradesPick pick;

    @JsonProperty("player")
    private SrNflV7TradesPlayer player;

    @JsonProperty("type")
    private String type;

    public Optional<SrNflV7TradesFuturePick> getFuturePick() {
        return Optional.ofNullable(futurePick);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<SrNflV7TradesPick> getPick() {
        return Optional.ofNullable(pick);
    }

    public Optional<SrNflV7TradesPlayer> getPlayer() {
        return Optional.ofNullable(player);
    }

    public Optional<String> getType() {
        return Optional.ofNullable(type);
    }
}
