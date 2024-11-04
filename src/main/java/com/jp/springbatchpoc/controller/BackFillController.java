package com.jp.springbatchpoc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("back-fill")
@RequiredArgsConstructor
@Slf4j
public class BackFillController {
    private final JobLauncher jobLauncher;
    private final Job sportsLeaguesPopulationJob;
    private final Job teamsPopulationJob;
    private final Job competitorsPopulationJob;
    private final Job seasonsPopulationJob;
    private final Job eventsPopulationJob;
    private final Job eventInfoPopulationJob;
    private final Job competitorEventStatisticsPopulationJob;

    @GetMapping("all")
    public void backFillEverything() {
        backFillEnums();
        backFillTeams();
        backFillCompetitors();
        backFillSeasons();
        backFillEvents();
        backFillEventInfo();
        backFillCompetitorEventStatistics();
    }

    @GetMapping("enums")
    public void backFillEnums() {
        System.out.println("Starting sportsLeaguesPopulationJob");
        runJob(sportsLeaguesPopulationJob);
    }

    @GetMapping("teams")
    public void backFillTeams() {
        System.out.println("Starting teamsPopulationJob");
        runJob(teamsPopulationJob);
    }

    @GetMapping("competitors")
    public void backFillCompetitors() {
        System.out.println("Starting competitorsPopulationJob");
        runJob(competitorsPopulationJob);
    }

    @GetMapping("seasons")
    public void backFillSeasons() {
        System.out.println("Starting seasonsPopulationJob");
        runJob(seasonsPopulationJob);
    }

    @GetMapping("events")
    public void backFillEvents() {
        System.out.println("Starting eventsPopulationJob");
        runJob(eventsPopulationJob);
    }

    @GetMapping("event-info")
    public void backFillEventInfo() {
        System.out.println("Starting eventInfoPopulationJob");
        runJob(eventInfoPopulationJob);
    }

    @GetMapping("competitor-event-statistics")
    public void backFillCompetitorEventStatistics() {
        System.out.println("Starting competitorEventStatisticsPopulationJob");
        runJob(competitorEventStatisticsPopulationJob);
    }

    private void runJob(Job job) {
        try {
            JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Job Status : " + execution.getStatus());
            System.out.println("Job completed");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Job failed");
        }
    }
}
