package com.oz.ozHouse.merchant.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.oz.ozHouse.merchant.service.SchedulerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class MerDeleteSchedulerConfig {
	private final SchedulerService schedulerService;
	
	
	@Scheduled( cron = "*/10 * * * * ?")
	public void run() {
		System.out.println("Scheduler 시작!");
		String test = schedulerService.merId(1);
		System.out.println("mybatisTest : " + test);
		if(test == null || test == "")
			System.out.println("mybatisTest : not result");
	}
}
