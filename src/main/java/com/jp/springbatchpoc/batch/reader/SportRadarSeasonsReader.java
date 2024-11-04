package com.jp.springbatchpoc.batch.reader;

import com.jp.springbatchpoc.client.sportradar.nflv7.SportRadarNflV7Client;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasons.SrNflV7SeasonsResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasons.SrNflV7SeasonsSeason;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;

@RequiredArgsConstructor
public class SportRadarSeasonsReader implements ItemReader<SrNflV7SeasonsSeason> {

    private final SportRadarNflV7Client sportRadarNflV7Client;
    private List<SrNflV7SeasonsSeason> seasons;

    @Override
    public SrNflV7SeasonsSeason read() throws Exception {
        if (seasons == null) {
            SrNflV7SeasonsResponse srNflV7SeasonsResponse =
                    sportRadarNflV7Client.getSeasons().block();
            if (srNflV7SeasonsResponse != null) {
                seasons = srNflV7SeasonsResponse.getSeasons();
            }
        }
        if (seasons != null && !seasons.isEmpty()) {
            return seasons.remove(0);
        }
        return null;
    }
}
