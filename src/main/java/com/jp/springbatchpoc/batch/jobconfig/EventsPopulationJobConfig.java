package com.jp.springbatchpoc.batch.jobconfig;

import com.jp.springbatchpoc.batch.processor.NflSeasonWithSportRadarWeekAndGameProcessor;
import com.jp.springbatchpoc.batch.reader.SportRadarScheduleReader;
import com.jp.springbatchpoc.client.sportradar.nflv7.SportRadarNflV7Client;
import com.jp.springbatchpoc.model.entity.Event;
import com.jp.springbatchpoc.repository.EventAssociationRepository;
import com.jp.springbatchpoc.repository.EventProviderIdRepository;
import com.jp.springbatchpoc.repository.EventRepository;
import com.jp.springbatchpoc.repository.TeamProviderIdRepository;
import com.jp.springbatchpoc.repository.VenueRepository;
import com.jp.springbatchpoc.service.EventAssociationTypeService;
import com.jp.springbatchpoc.service.EventStatusService;
import com.jp.springbatchpoc.service.SeasonService;
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
public class EventsPopulationJobConfig {

    @Bean(name = "eventsPopulationStep")
    protected Step eventsPopulationStep(
            PlatformTransactionManager transactionManager,
            JobRepository jobRepository,
            EventRepository eventRepository,
            SportRadarScheduleReader sportRadarScheduleReader,
            NflSeasonWithSportRadarWeekAndGameProcessor nflSeasonWithSportRadarWeekAndGameProcessor) {
        RepositoryItemWriter<Event> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(eventRepository);
        return new StepBuilder("eventsPopulationStep", jobRepository)
                .<SportRadarScheduleReader.SportRadarWeekAndGameWithNflSeason, Event>chunk(100, transactionManager)
                .allowStartIfComplete(true)
                .reader(sportRadarScheduleReader)
                .processor(nflSeasonWithSportRadarWeekAndGameProcessor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    @JobScope
    public SportRadarScheduleReader sportRadarScheduleReader(
            SeasonService seasonService, SportRadarNflV7Client sportRadarNflV7Client) {
        return new SportRadarScheduleReader(seasonService, sportRadarNflV7Client);
    }

    @Bean
    @JobScope
    public NflSeasonWithSportRadarWeekAndGameProcessor nflSeasonWithSportRadarWeekAndGameProcessor(
            EventProviderIdRepository eventProviderIdRepository,
            EventStatusService eventStatusService,
            EventAssociationRepository eventAssociationRepository,
            EventAssociationTypeService eventAssociationTypeService,
            TeamProviderIdRepository teamProviderIdRepository,
            VenueRepository venueRepository) {
        return new NflSeasonWithSportRadarWeekAndGameProcessor(
                eventProviderIdRepository,
                eventStatusService,
                eventAssociationRepository,
                eventAssociationTypeService,
                teamProviderIdRepository,
                venueRepository);
    }

    @Bean(name = "eventsPopulationJob")
    public Job job(JobRepository jobRepository, @Qualifier("eventsPopulationStep") Step step) {
        return new JobBuilder("eventsPopulationJob", jobRepository).start(step).build();
    }
}
