package com.example.myapplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout_statistics")
data class WorkoutStatistic(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "distance_run")
    val distanceRun: Double?,

    @ColumnInfo(name = "distance_swim")
    val distanceSwim: Double?,

    @ColumnInfo(name = "calories")
    val calories: Double?
)