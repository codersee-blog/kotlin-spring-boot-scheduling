package com.codersee.scheduled.controller

import com.codersee.scheduled.service.ManualTaskSchedulerService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TestController(
        private val manualTaskSchedulerService: ManualTaskSchedulerService
) {

    private val logger: Logger = LoggerFactory.getLogger(TestController::class.java)

    @PostMapping("/task")
    fun createTask(@RequestParam name: String): ResponseEntity<Int> {
        val task = Runnable { logger.info("Passed name: $name") }

        val createdTaskId = manualTaskSchedulerService.addNewTask(task)

        return ResponseEntity.ok(createdTaskId)
    }

    @DeleteMapping("/task/{taskId}")
    fun deleteTask(@PathVariable taskId: Int) {
        manualTaskSchedulerService.removeTaskFromScheduler(taskId)
    }
}