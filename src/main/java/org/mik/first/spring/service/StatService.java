package org.mik.first.spring.service;

import lombok.extern.log4j.Log4j2;
import org.mik.first.spring.component.AppStatistics;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@Log4j2
public class StatService {

    private final AppStatistics appStatistics;

    public StatService(AppStatistics appStatistics){
        this.appStatistics=appStatistics;
    }
    @Scheduled(fixedRate = 60000)
    private void bg(){
        log.info("BG task started");
        this.appStatistics.increment("statService");
    }
}
