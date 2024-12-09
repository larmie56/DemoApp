package com.example.demoapp.domain

import com.example.demoapp.data.entity.Tasks
import com.example.demoapp.data.repo.TasksRepo

class EditTaskUseCase(private val tasksRepo: TasksRepo) {

    suspend fun execute(task: Tasks) {
        tasksRepo.updateTask(task)
    }
}