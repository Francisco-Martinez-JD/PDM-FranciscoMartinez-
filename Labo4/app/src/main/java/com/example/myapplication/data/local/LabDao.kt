package com.example.myapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.local.entities.Task
import kotlinx.coroutines.flow.Flow


@Dao
interface LabDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<Task>>

}