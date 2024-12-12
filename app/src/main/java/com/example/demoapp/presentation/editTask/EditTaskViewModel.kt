package com.example.demoapp.presentation.editTask

import com.example.demoapp.data.entity.Tasks
import com.example.demoapp.domain.CreateTaskUseCase
import com.example.demoapp.domain.EditTaskUseCase
import com.example.demoapp.domain.GetTaskUseCase

class EditTaskViewModel(
    private val getTaskUseCase: GetTaskUseCase,
    private val editTaskUseCase: EditTaskUseCase,
    private val createTaskUseCase: CreateTaskUseCase,
) {

    suspend fun getTask(id: Long): Tasks? = getTaskUseCase.execute(id)

    suspend fun createTask(tasks: Tasks) = createTaskUseCase.execute(tasks)

    suspend fun editTask(tasks: Tasks) = editTaskUseCase.execute(tasks)
}