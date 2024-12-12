package com.example.demoapp.presentation.allTasks

import androidx.lifecycle.ViewModel
import com.example.demoapp.data.entity.Tasks
import com.example.demoapp.domain.DeleteTasksUseCase
import com.example.demoapp.domain.GetAllTasksUseCase

class AllTasksViewModel(
    private val getAllTasksUseCase: GetAllTasksUseCase,
    private val deleteTasksUseCase: DeleteTasksUseCase
) : ViewModel() {

    suspend fun getAllTask(): List<Tasks> = getAllTasksUseCase.execute()
}