package com.example.demoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
public data class Tasks(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "priority")
    val priority: Int,
    @ColumnInfo(name = "date")
    val date: Long,
    @ColumnInfo(name = "info")
    val info: String,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0L
)