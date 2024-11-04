package com.jp.springbatchpoc.batch.jobconfig;

import com.jp.springbatchpoc.batch.processor.NflSeasonProcessor;
import com.jp.springbatchpoc.batch.reader.SportRadarSeasonsReader;
import com.jp.springbatchpoc.client.sportradar.nflv7.SportRadarNflV7Client;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasons.SrNflV7SeasonsSeason;
import com.jp.springbatchpoc.model.entity.Season;
import com.jp.springbatchpoc.repository.SeasonRepository;
import com.jp.springbatchpoc.service.LeagueService;
import com.jp.springbatchpoc.service.SeasonTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
public class SeasonPopulationJobConfiguration {

    @Bean(name = "seasonsPopulationStep")
    protected Step seasonsPopulationStep(
            PlatformTransactionManager transactionManager,
            JobRepository jobRepository,
            SportRadarNflV7Client sportRadarNflV7Client,
            SeasonRepository seasonRepository,
            SeasonTypeService seasonTypeService,
            LeagueService leagueService) {
        RepositoryItemWriter<Season> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(seasonRepository);
        return new StepBuilder("seasonsPopulationStep", jobRepository)
                .<SrNflV7SeasonsSeason, Season>chunk(5, transactionManager)
                .allowStartIfComplete(true)
                .reader(new SportRadarSeasonsReader(sportRadarNflV7Client))
                .processor(new NflSeasonProcessor(leagueService, seasonTypeService))
                .writer(itemWriter)
                .build();
    }

    @Bean(name = "seasonsPopulationJob")
    public Job job(JobRepository jobRepository, @Qualifier("seasonsPopulationStep") Step step) {
        return new JobBuilder("seasonsPopulationJob", jobRepository).start(step).build();
    }
}
