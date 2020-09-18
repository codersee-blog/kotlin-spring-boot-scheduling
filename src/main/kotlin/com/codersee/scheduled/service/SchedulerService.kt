package com.codersee.scheduled.service

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class SchedulerService {

    @Scheduled(fixedRate = 3000)
    fun fixedRateScheduledTask() {
        //Some code here
    }

    @Scheduled(fixedDelay = 3000)
    fun fixedDelayScheduledTask() {
        //Some code here
    }

    @Scheduled(initialDelay = 2000, fixedDelay = 3000)
    fun initialDelayScheduledTask() {
        //Some code here
    }
    @Scheduled(cron = "0/3 * * * * *")
    fun cronScheduledTask() {
        //Some code here
    }

    @Scheduled(cron = "\${my.cron.value}")
    fun cronScheduledTaskUsingProperties() {
        //Some code here
    }
}