package com.oz.ozHouse.merchant.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class MerDeleteSchedulerConfig {
	
	@Scheduled( cron = "0/10 0 * * * ?")
	public void run() {
		System.out.println("Scheduler 시작!");
	}
}
