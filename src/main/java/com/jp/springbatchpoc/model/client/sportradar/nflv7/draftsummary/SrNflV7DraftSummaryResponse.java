package com.jp.springbatchpoc.model.client.sportradar.nflv7.draftsummary;

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
public class SrNflV7DraftSummaryResponse {
    @JsonProperty("_comment")
    private String comment;

    @JsonProperty("draft")
    private SrNflV7DraftSummaryDraft draft;

    @JsonProperty("rounds")
    private List<SrNflV7DraftSummaryRound> rounds;

    public Optional<String> getComment() {
        return Optional.ofNullable(comment);
    }

    public Optional<SrNflV7DraftSummaryDraft> getDraft() {
        return Optional.ofNullable(draft);
    }

    public List<SrNflV7DraftSummaryRound> getRounds() {
        return Optional.ofNullable(rounds).orElse(Collections.emptyList());
    }
}
