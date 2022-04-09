package com.example.myapplication.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WorkoutStatisticDao {

    @Insert
    fun insert(vararg workoutStatistic: WorkoutStatistic)

    @Query("SELECT avg(distance_run) as average_run, avg(distance_swim) as average_swim, avg(calories) as average_calories FROM workout_statistics")
    fun getAvgStats(): Average

    @Query("SELECT sum(distance_run) FROM workout_statistics")
    fun getSumRun(): Double
}