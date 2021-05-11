package com.example.ageinminute

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val tvSelectedDate = findViewById<TextView>(R.id.tvSelectedDate)
        val tvAgeInMinute = findViewById<TextView>(R.id.tvAgeInMinute)

        val today = Calendar.getInstance()
        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)
        ) {
            view, year, month, day ->
            val month = month + 1
            val msg = "$day/$month/$year"
            tvSelectedDate.text = msg
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(msg)
            val selectedDateInMinute = theDate!!.time / 60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinute = currentDate!!.time / 60000
            tvAgeInMinute.text = (currentDateInMinute - selectedDateInMinute).toString()
        }
    }
}