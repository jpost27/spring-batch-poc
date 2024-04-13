package com.jp.springbatchpoc.model.client.sportradar.nflv7.teamdraftsummary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.Integer;
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
public class SrNflV7TeamDraftSummaryPick {
    @JsonProperty("id")
    private String id;

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("overall")
    private Integer overall;

    @JsonProperty("prospect")
    private SrNflV7TeamDraftSummaryProspect prospect;

    @JsonProperty("team")
    private SrNflV7TeamDraftSummaryTeam team;

    @JsonProperty("traded")
    private Boolean traded;

    @JsonProperty("trades")
    private List<SrNflV7TeamDraftSummaryTrade> trades;

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<Integer> getNumber() {
        return Optional.ofNullable(number);
    }

    public Optional<Integer> getOverall() {
        return Optional.ofNullable(overall);
    }

    public Optional<SrNflV7TeamDraftSummaryProspect> getProspect() {
        return Optional.ofNullable(prospect);
    }

    public Optional<SrNflV7TeamDraftSummaryTeam> getTeam() {
        return Optional.ofNullable(team);
    }

    public Optional<Boolean> getTraded() {
        return Optional.ofNullable(traded);
    }

    public List<SrNflV7TeamDraftSummaryTrade> getTrades() {
        return Optional.ofNullable(trades).orElse(Collections.emptyList());
    }
}
