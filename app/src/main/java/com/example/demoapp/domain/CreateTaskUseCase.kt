package com.example.demoapp.domain

import com.example.demoapp.data.entity.Tasks
import com.example.demoapp.data.repo.TasksRepo

class CreateTaskUseCase(private val tasksRepo: TasksRepo) {

    suspend fun execute(task: Tasks) {
        tasksRepo.insertTask(task)
    }
}
