package com.jp.springbatchpoc.batch.jobconfig;

import com.jp.springbatchpoc.batch.tasklet.EnumsPopulationTasklet;
import com.jp.springbatchpoc.repository.LeagueRepository;
import com.jp.springbatchpoc.repository.SportRepository;
import com.jp.springbatchpoc.repository.TeamAssociationTypeRepository;
import com.jp.springbatchpoc.repository.TeamColorTypeRepository;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Setter
@Configuration
public class SportsLeaguesPopulationJobConfiguration {

    @Bean(name = "sportsLeaguesPopulationStep")
    protected Step sportsLeaguesPopulationStep(
            PlatformTransactionManager transactionManager,
            JobRepository jobRepository,
            SportRepository sportsRepository,
            LeagueRepository leagueRepository,
            TeamAssociationTypeRepository teamAssociationTypeRepository,
            TeamColorTypeRepository teamColorTypeRepository
            ) {
        TaskletStep step = new TaskletStep("SportsLeaguesPopulationTasklet");
        step.setAllowStartIfComplete(true);
        step.setJobRepository(jobRepository);
        step.setTransactionManager(transactionManager);
        step.setTasklet(new EnumsPopulationTasklet(
                sportsRepository,
                leagueRepository,
                teamAssociationTypeRepository,
                teamColorTypeRepository));
        return step;
    }

    @Bean(name = "sportsLeaguesPopulationJob")
    public Job job(JobRepository jobRepository, @Qualifier("sportsLeaguesPopulationStep") Step step) {
        return new JobBuilder("sportsLeaguesPopulationJob", jobRepository)
                .start(step)
                .build();
    }

}
