package com.example.demoapp.domain

import com.example.demoapp.data.entity.Tasks
import com.example.demoapp.data.repo.TasksRepo

class GetTaskUseCase(private val tasksRepo: TasksRepo) {

    suspend fun execute(id: Long): Tasks? = tasksRepo.getTask(id)
}