package com.example.scheduler.service;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleJobService implements Job {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
        
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("@@@@@@@@@@@@@@@@@@ execute(JobExecutionContext context) " );
        log.info("OOO JOB [{}] executed.", this.getClass().getSimpleName());
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        mergedJobDataMap.forEach((k, v) -> log.info("OOOOO {}: {}", k, v));
    }

}