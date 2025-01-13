package com.example.demoapp.domain

import androidx.lifecycle.LiveData
import com.example.demoapp.data.entity.Tasks
import com.example.demoapp.data.repo.TasksRepo

class GetAllTasksUseCase(private val tasksRepo: TasksRepo) {

    suspend fun execute(): LiveData<List<Tasks>> = tasksRepo.getAllTasks()
}