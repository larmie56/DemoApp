package com.example.demoapp.domain

import com.example.demoapp.data.entity.Tasks
import com.example.demoapp.data.repo.TasksRepo

class GetAllTasksUseCase(private val tasksRepo: TasksRepo) {

    suspend fun execute(): List<Tasks> = tasksRepo.getAllTasks()
}