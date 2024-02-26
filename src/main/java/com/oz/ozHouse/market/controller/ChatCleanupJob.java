package com.oz.ozHouse.market.controller;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oz.ozHouse.market.service.ChattService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class ChatCleanupJob implements Job {

    @Autowired
    private ChattService chattService; // 채팅 서비스에 대한 의존성 주입

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);

        // 7일 이전의 채팅 내역 삭제
        chattService.deleteChatHistoryBefore(sevenDaysAgo);
    }
}
