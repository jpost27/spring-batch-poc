package com.jp.springbatchpoc.batch.jobconfig;

import com.jp.springbatchpoc.batch.processor.EventProcessor;
import com.jp.springbatchpoc.batch.reader.EventReader;
import com.jp.springbatchpoc.client.sportradar.nflv7.SportRadarNflV7Client;
import com.jp.springbatchpoc.model.entity.Event;
import com.jp.springbatchpoc.repository.CompetitorProviderIdRepository;
import com.jp.springbatchpoc.repository.EventRepository;
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
public class EventInfoPopulationJobConfig {

    @Bean(name = "eventInfoPopulationStep")
    protected Step eventInfoPopulationStep(
            PlatformTransactionManager transactionManager,
            JobRepository jobRepository,
            EventReader eventReader,
            EventProcessor eventProcessor,
            EventRepository eventRepository) {
        RepositoryItemWriter<Event> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(eventRepository);
        return new StepBuilder("eventInfoPopulationStep", jobRepository)
                .<Event, Event>chunk(5, transactionManager)
                .allowStartIfComplete(true)
                .reader(eventReader)
                .processor(eventProcessor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    @JobScope
    public EventReader eventReader(EventRepository eventRepository) {
        return new EventReader(eventRepository);
    }

    @Bean
    @JobScope
    public EventProcessor eventProcessor(
            SportRadarNflV7Client sportRadarNflV7Client,
            CompetitorProviderIdRepository competitorProviderIdRepository) {
        return new EventProcessor(sportRadarNflV7Client, competitorProviderIdRepository);
    }

    @Bean(name = "eventInfoPopulationJob")
    public Job job(JobRepository jobRepository, @Qualifier("eventInfoPopulationStep") Step step) {
        return new JobBuilder("eventInfoPopulationJob", jobRepository)
                .start(step)
                .build();
    }
}
