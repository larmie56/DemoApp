package com.example.demoapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demoapp.data.dao.TasksDao
import com.example.demoapp.data.entity.Tasks

@Database(entities = [Tasks::class], version = 1, exportSchema = false)
internal abstract class TodoDatabase : RoomDatabase() {

    abstract val tasksDao: TasksDao

    companion object {
        private const val DATABASE_NAME: String = "todo_db"
        fun build(context: Context): TodoDatabase = Room.databaseBuilder(
            context.applicationContext,
            TodoDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}
