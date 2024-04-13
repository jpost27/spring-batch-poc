package com.jp.springbatchpoc.batch.jobconfig;

import com.jp.springbatchpoc.batch.tasklet.SportsLeaguesPopulationTasklet;
import com.jp.springbatchpoc.model.entity.League;
import com.jp.springbatchpoc.repository.LeagueRepository;
import com.jp.springbatchpoc.repository.SportRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.tasklet.CallableTaskletAdapter;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Slf4j
@Setter
@Configuration
@ConfigurationProperties(value = "initialization")
public class SportsLeaguesPopulationJobConfiguration {

    private Map<String, List<League>> sportsLeaguesMap;

    @PostConstruct
    public void validate() {
        Assert.notNull(sportsLeaguesMap, "sportsLeaguesMap must not be null!");
    }

    @Bean(name = "sportsLeaguesPopulationStep")
    protected Step sportsLeaguesPopulationStep(
            PlatformTransactionManager transactionManager,
            JobRepository jobRepository,
            SportRepository sportsRepository,
            LeagueRepository leagueRepository
            ) {
        TaskletStep step = new TaskletStep("SportsLeaguesPopulationTasklet");
        step.setAllowStartIfComplete(true);
        step.setJobRepository(jobRepository);
        step.setTransactionManager(transactionManager);
        step.setTasklet(new SportsLeaguesPopulationTasklet(sportsLeaguesMap, sportsRepository, leagueRepository));
        return step;
    }

    @Bean(name = "sportsLeaguesPopulationJob")
    public Job job(JobRepository jobRepository, @Qualifier("sportsLeaguesPopulationStep") Step step) {
        return new JobBuilder("sportsLeaguesPopulationJob", jobRepository)
                .start(step)
                .build();
    }

}
