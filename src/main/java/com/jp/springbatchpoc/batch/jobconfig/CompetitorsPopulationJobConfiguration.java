package com.jp.springbatchpoc.batch.jobconfig;

import com.jp.springbatchpoc.batch.processor.NflPlayerIdentifierProcessor;
import com.jp.springbatchpoc.batch.reader.AlmanacCompetitorIdentifiersReader;
import com.jp.springbatchpoc.client.sportradar.nflv7.SportRadarNflV7Client;
import com.jp.springbatchpoc.model.dto.CompetitorIdentifier;
import com.jp.springbatchpoc.model.entity.Competitor;
import com.jp.springbatchpoc.model.enums.Leagues;
import com.jp.springbatchpoc.repository.CompetitorProviderIdRepository;
import com.jp.springbatchpoc.repository.CompetitorRepository;
import com.jp.springbatchpoc.repository.SportPositionRepository;
import com.jp.springbatchpoc.repository.TeamProviderIdRepository;
import com.jp.springbatchpoc.service.CompetitorIdentifierService;
import com.jp.springbatchpoc.service.SportService;
import com.jp.springbatchpoc.service.TeamIdentifierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
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
public class CompetitorsPopulationJobConfiguration {

    @JobScope
    @Bean(name = "competitorsPopulationStep")
    protected Step competitorsPopulationStep(
            PlatformTransactionManager transactionManager,
            JobRepository jobRepository,
            CompetitorIdentifierService competitorIdentifierService,
            SportRadarNflV7Client sportRadarNflV7Client,
            CompetitorRepository competitorRepository,
            TeamIdentifierService teamIdentifierService,
            TeamProviderIdRepository teamProviderIdRepository,
            CompetitorProviderIdRepository competitorProviderIdRepository,
            SportService sportService,
            SportPositionRepository sportPositionRepository) {
        RepositoryItemWriter<Competitor> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(competitorRepository);
        return new StepBuilder("competitorsPopulationStep", jobRepository)
                .<CompetitorIdentifier, Competitor>chunk(5, transactionManager)
                .allowStartIfComplete(true)
                .reader(new AlmanacCompetitorIdentifiersReader(
                        teamIdentifierService, competitorIdentifierService, Leagues.NFL))
                .processor(new NflPlayerIdentifierProcessor(
                        sportRadarNflV7Client,
                        teamProviderIdRepository,
                        competitorProviderIdRepository,
                        sportService,
                        sportPositionRepository))
                .writer(itemWriter)
                .build();
    }

    @Bean(name = "competitorsPopulationJob")
    public Job job(JobRepository jobRepository, @Qualifier("competitorsPopulationStep") Step step) {
        return new JobBuilder("competitorsPopulationJob", jobRepository)
                .start(step)
                .build();
    }
}
