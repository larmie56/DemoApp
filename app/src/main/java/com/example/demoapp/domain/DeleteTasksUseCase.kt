package com.example.demoapp.domain

import com.example.demoapp.data.repo.TasksRepo

class DeleteTasksUseCase(private val tasksRepo: TasksRepo) {

    suspend fun execute(id: Long) {
        tasksRepo.deleteTask(id)
    }
}