package com.codersee.scheduled.service

import org.springframework.scheduling.TaskScheduler
import org.springframework.stereotype.Service
import java.time.Duration
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.atomic.AtomicInteger

@Service
class ManualTaskSchedulerService(
        private val scheduler: TaskScheduler
) {
    val futures: MutableMap<Int, ScheduledFuture<*>> = HashMap()
    val taskId = AtomicInteger()

    fun addNewTask(task: Runnable): Int {
        val taskPeriod = Duration.ofSeconds(2)
        val scheduledTaskFuture = scheduler.scheduleAtFixedRate(task, taskPeriod)

        val id = taskId.incrementAndGet()
        futures[id] = scheduledTaskFuture

        return id
    }

    fun removeTaskFromScheduler(id: Int) {
        futures[id]?.let {
            it.cancel(true)
            futures.remove(id)
        }
    }
}