package com.jp.springbatchpoc.model.client.sportradar.nflv7.prospects;

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
public class SrNflV7ProspectsResponse {
    @JsonProperty("_comment")
    private String comment;

    @JsonProperty("draft")
    private SrNflV7ProspectsDraft draft;

    @JsonProperty("prospects")
    private List<SrNflV7ProspectsProspect> prospects;

    public Optional<String> getComment() {
        return Optional.ofNullable(comment);
    }

    public Optional<SrNflV7ProspectsDraft> getDraft() {
        return Optional.ofNullable(draft);
    }

    public List<SrNflV7ProspectsProspect> getProspects() {
        return Optional.ofNullable(prospects).orElse(Collections.emptyList());
    }
}
