package com.example.timepicker_1

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextClock
import android.widget.TextView
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeSelBt = findViewById<Button>(R.id.btSelectTime)
        val txtClock = findViewById<TextClock>(R.id.textClock)
        val txtView = findViewById<TextView>(R.id.textView)
        val timeClk = findViewById<TextClock>(R.id.textClock)

                timeSelBt.setOnClickListener {
                curentTimePicker()
        }
    }

           @SuppressLint("SetTextI18n")
           private fun curentTimePicker() { //Получаем текущее время
            val cal = Calendar.getInstance()
            val hour: Int = cal.get(Calendar.HOUR_OF_DAY)
            val minute: Int = cal.get(Calendar.MINUTE)
               val second: Int = cal.get(Calendar.SECOND)
               var h: String = "0"
               var m: String = "0"
               var s: String = "0"
               if (hour < 10) {h = "0"} else {h = ""}
               if (minute < 10) {m = "0"} else {m = ""}
               if (second < 10) {s = "0"} else {s = ""}
               val timeTextEd = findViewById<EditText>(R.id.editTextTime)
               timeTextEd.setText("$h$hour:$m$minute:$s$second")

        }



}
