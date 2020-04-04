package com.example.scheduler.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.CronScheduleBuilder;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Component
public class InitRunner implements CommandLineRunner  {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private Scheduler scheduler;

    @Override
    public void run(final String... args) throws Exception {
        log.info("### Init Runner executed.");

        final StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
        scheduler = schedulerFactory.getScheduler();

        final JobKey jobKey = JobKey.jobKey("jobkey1", "jobgroup1");
        final JobDetail jobDetail = buildJobDetail(jobKey);
        final Trigger trigger = buildJobTrigger(jobKey);
        scheduler.scheduleJob(jobDetail, trigger); // (1)

    }

    private JobDetail buildJobDetail(final JobKey jobKey) throws ClassNotFoundException {
        log.info("### buildJobDetail.");
        final JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("key1", "value1");
        jobDataMap.put("key2", 2);

        return JobBuilder.newJob(InitRunner.class) // (2)
                .withIdentity(jobKey).withDescription("Simple Quartz Job Detail").usingJobData(jobDataMap).build();
    }

    private Trigger buildJobTrigger(final JobKey jobKey) {
        log.info("### buildJobTrigger.");
        return TriggerBuilder.newTrigger().forJob(jobKey).withDescription("Simple Quartz Job Trigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("5 * * * * ?")).build();
    }
    
}