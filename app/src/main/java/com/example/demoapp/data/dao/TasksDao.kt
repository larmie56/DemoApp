package com.example.demoapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.demoapp.data.entity.Tasks

@Dao
internal interface TasksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Tasks): Long

    @Update
    suspend fun updateTask(task: Tasks)

    @Query("SELECT * FROM tasks WHERE id = :id")
    suspend fun getTask(id: Long): Tasks?

    @Query("SELECT * FROM tasks ORDER BY date ASC")
    suspend fun getTaskByDate(): List<Tasks>

    @Query("SELECT * FROM tasks ORDER BY priority ASC, date ASC")
    suspend fun getTasksByPriority(): List<Tasks>

    @Query("DELETE FROM tasks WHERE id = :id")
    suspend fun deleteTask(id: Long)
}