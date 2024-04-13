package com.jp.springbatchpoc.model.client.sportradar.nflv7.draftsummary;

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
public class SrNflV7DraftSummaryPick {
    @JsonProperty("id")
    private String id;

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("overall")
    private Integer overall;

    @JsonProperty("prospect")
    private SrNflV7DraftSummaryProspect prospect;

    @JsonProperty("supplemental")
    private Boolean supplemental;

    @JsonProperty("team")
    private SrNflV7DraftSummaryTeam team;

    @JsonProperty("traded")
    private Boolean traded;

    @JsonProperty("trades")
    private List<SrNflV7DraftSummaryTrade> trades;

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<Integer> getNumber() {
        return Optional.ofNullable(number);
    }

    public Optional<Integer> getOverall() {
        return Optional.ofNullable(overall);
    }

    public Optional<SrNflV7DraftSummaryProspect> getProspect() {
        return Optional.ofNullable(prospect);
    }

    public Optional<Boolean> getSupplemental() {
        return Optional.ofNullable(supplemental);
    }

    public Optional<SrNflV7DraftSummaryTeam> getTeam() {
        return Optional.ofNullable(team);
    }

    public Optional<Boolean> getTraded() {
        return Optional.ofNullable(traded);
    }

    public List<SrNflV7DraftSummaryTrade> getTrades() {
        return Optional.ofNullable(trades).orElse(Collections.emptyList());
    }
}
