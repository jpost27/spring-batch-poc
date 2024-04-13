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

    @GetMapping("sports-and-leagues")
    public void backFillSportsAndLeagues() {
        System.out.println("Starting sportsLeaguesPopulationJob");
        try {
            JobExecution execution = jobLauncher.run(
                    sportsLeaguesPopulationJob,
                    new JobParameters());
            System.out.println("Job Status : " + execution.getStatus());
            System.out.println("Job completed");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Job failed");
        }
    }

}
