package com.jp.springbatchpoc.batch.jobconfig;

import com.jp.springbatchpoc.batch.processor.CompetitorsEventsProcessor;
import com.jp.springbatchpoc.batch.reader.CompetitorsEventsReader;
import com.jp.springbatchpoc.client.sportradar.nflv7.SportRadarNflV7Client;
import com.jp.springbatchpoc.model.entity.CompetitorsEvents;
import com.jp.springbatchpoc.repository.CompetitorsEventsRepository;
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
public class CompetitorEventStatisticsPopulationJobConfig {

    @Bean(name = "competitorEventStatisticsPopulationStep")
    protected Step competitorEventStatisticsPopulationStep(
            PlatformTransactionManager transactionManager,
            JobRepository jobRepository,
            CompetitorsEventsReader competitorsEventsReader,
            CompetitorsEventsProcessor competitorsEventsProcessor,
            CompetitorsEventsRepository competitorsEventsRepository) {
        RepositoryItemWriter<CompetitorsEvents> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(competitorsEventsRepository);
        return new StepBuilder("competitorEventStatisticsPopulationStep", jobRepository)
                .<CompetitorsEvents, CompetitorsEvents>chunk(5, transactionManager)
                .allowStartIfComplete(true)
                .reader(competitorsEventsReader)
                .processor(competitorsEventsProcessor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    @JobScope
    public CompetitorsEventsReader competitorsEventsReader(CompetitorsEventsRepository competitorsEventsRepository) {
        return new CompetitorsEventsReader(competitorsEventsRepository);
    }

    @Bean
    @JobScope
    public CompetitorsEventsProcessor competitorsEventsProcessor(SportRadarNflV7Client sportRadarNflV7Client) {
        return new CompetitorsEventsProcessor(sportRadarNflV7Client);
    }

    @Bean(name = "competitorEventStatisticsPopulationJob")
    public Job job(JobRepository jobRepository, @Qualifier("competitorEventStatisticsPopulationStep") Step step) {
        return new JobBuilder("competitorEventStatisticsPopulationJob", jobRepository)
                .start(step)
                .build();
    }
}
