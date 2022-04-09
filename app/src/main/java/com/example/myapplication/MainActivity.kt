package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.room.WorkoutStatistic

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateStats()
        val saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener {
            insertStats()
            updateStats()
        }
    }

    private fun updateStats(){
        val average = App.instance.db.getWorkoutStatisticDao().getAvgStats()
        val sumRun = App.instance.db.getWorkoutStatisticDao().getSumRun()

        val averageRunField: TextView = findViewById(R.id.average_run)
        val averageSwimField: TextView = findViewById(R.id.average_swim)
        val averageCaloriesField: TextView = findViewById(R.id.average_calories)
        val sumRunField: TextView = findViewById(R.id.sum_run)
        averageRunField.text = String.format("%.2f", average.average_run)
        averageSwimField.text = String.format("%.2f", average.average_swim)
        averageCaloriesField.text = String.format("%.2f", average.average_calories)
        sumRunField.text = String.format("%.2f", sumRun)

    }

    private fun insertStats(){
        val distanceRun = findViewById<TextView>(R.id.distance_run).text.toString()
        val distanceSwim = findViewById<TextView>(R.id.distance_swim).text.toString()
        val calories = findViewById<TextView>(R.id.calories).text.toString()
        if (distanceRun != "" && distanceSwim != "" && calories != ""){
            App.instance.db.getWorkoutStatisticDao().insert(WorkoutStatistic(0, distanceRun = distanceRun.toDouble(), distanceSwim = distanceSwim.toDouble(), calories = calories.toDouble()))
        }else{
            Toast.makeText(this,"გთხოვთ შეავსოთ ყველა ველი!",Toast.LENGTH_LONG).show()
        }

    }


}