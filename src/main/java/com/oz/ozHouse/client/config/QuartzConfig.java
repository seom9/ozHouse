package com.oz.ozHouse.client.config;

import org.springframework.context.ApplicationContext;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oz.ozHouse.market.controller.ChatCleanupJob;

@Configuration
public class QuartzConfig {
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @Bean
    public JobDetail chatCleanupJobDetail() {
        return JobBuilder.newJob(ChatCleanupJob.class)
                .withIdentity("ChatCleanupJob")
                .storeDurably()
                .build();
    }
    
    @Bean
    public Trigger chatCleanupJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInMinutes(5) // Run every 5 minutes, adjust as needed
                .repeatForever();
        
        return TriggerBuilder.newTrigger()
                .forJob(chatCleanupJobDetail())
                .withIdentity("ChatCleanupTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }
}

