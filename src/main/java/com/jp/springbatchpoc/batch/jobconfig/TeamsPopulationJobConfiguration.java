package com.jp.springbatchpoc.batch.jobconfig;

import com.jp.springbatchpoc.batch.processor.NflTeamIdentifierProcessor;
import com.jp.springbatchpoc.batch.reader.AlmanacTeamIdentifiersReader;
import com.jp.springbatchpoc.client.sportradar.nflv7.SportRadarNflV7Client;
import com.jp.springbatchpoc.model.dto.TeamIdentifier;
import com.jp.springbatchpoc.model.entity.Team;
import com.jp.springbatchpoc.model.enums.Leagues;
import com.jp.springbatchpoc.repository.TeamAssociationRepository;
import com.jp.springbatchpoc.repository.TeamRepository;
import com.jp.springbatchpoc.repository.VenueRepository;
import com.jp.springbatchpoc.service.LeagueService;
import com.jp.springbatchpoc.service.TeamIdentifierService;
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
public class TeamsPopulationJobConfiguration {

    @Bean(name = "teamsPopulationStep")
    protected Step teamsPopulationStep(
            PlatformTransactionManager transactionManager,
            JobRepository jobRepository,
            TeamIdentifierService teamIdentifierService,
            SportRadarNflV7Client sportRadarNflV7Client,
            LeagueService leagueService,
            TeamRepository teamRepository,
            TeamAssociationRepository teamAssociationRepository,
            VenueRepository venueRepository
    ) {
        RepositoryItemWriter<Team> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(teamRepository);
        return new StepBuilder("teamsPopulationStep", jobRepository)
                .<TeamIdentifier, Team> chunk(5, transactionManager)
                .allowStartIfComplete(true)
                .reader(new AlmanacTeamIdentifiersReader(teamIdentifierService, Leagues.NFL))
                .processor(new NflTeamIdentifierProcessor(
                        sportRadarNflV7Client,
                        leagueService,
                        teamAssociationRepository,
                        venueRepository
                ))
                .writer(itemWriter)
                .build();
    }

    @Bean(name = "teamsPopulationJob")
    public Job job(JobRepository jobRepository, @Qualifier("teamsPopulationStep") Step step) {
        return new JobBuilder("teamsPopulationJob", jobRepository)
                .start(step)
                .build();
    }
}
