package com.example.demoapp.data.repo

import android.content.Context
import com.example.demoapp.data.TodoDatabase
import com.example.demoapp.data.entity.Tasks

class TasksRepo(context: Context) {

    private val tasksDao = TodoDatabase.build(context).tasksDao

    suspend fun insertTask(task: Tasks) {
        tasksDao.insertTask(task)
    }

    suspend fun updateTask(task: Tasks) {
        tasksDao.updateTask(task)
    }

    suspend fun getTask(id: Long): Tasks? = tasksDao.getTask(id)

    suspend fun getAllTasks(): List<Tasks> = tasksDao.getAllTasks()

    suspend fun getTaskByDate(): List<Tasks> = tasksDao.getTaskByDate()

    suspend fun getTasksByPriority(): List<Tasks> = tasksDao.getTasksByPriority()

    suspend fun deleteTask(id: Long) {
        tasksDao.deleteTask(id)
    }
}