package com.example.timepicker_1

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dateSelBt = findViewById<Button>(R.id.btSelectDate)
        val timeSelBt = findViewById<Button>(R.id.btSelectTime)
        //val txtClock = findViewById<TextClock>(R.id.textClock)
        //val txtView = findViewById<TextView>(R.id.textView)
        //val timeClk = findViewById<TextClock>(R.id.textClock)

                timeSelBt.setOnClickListener {
                    randomTimePicker()
                }
                dateSelBt.setOnClickListener {
                    datePickerDialog()
                }


    }
    @SuppressLint("SetTextI18n")
    private fun randomTimePicker() {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR)
        val minute = c.get(Calendar.MINUTE)
        val timeTextEd = findViewById<EditText>(R.id.editTextTime)

        val tpd = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener(function = { view, h, m ->
            /*Toast.makeText(this, h.toString() + " : " + m , Toast.LENGTH_LONG).show()*/
            timeTextEd.setText("$h:$m")
        }),hour,minute,true)

        tpd.show()
    }

    private fun datePickerDialog() {
        val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)
        val dateTextEd = findViewById<EditText>(R.id.editTextDate)
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            dateTextEd.run {"$dayOfMonth-${monthOfYear + 1}-$year"}
            }, year, month, day)
        dpd.show()
    }

    @SuppressLint("SetTextI18n")
    private fun currentTimePicker() { //Получаем текущее время
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
    private fun  writeDateTime(){ //Выбираем дату и время
        val timeSelBt = findViewById<Button>(R.id.btSelectTime)
        val txtClock = findViewById<TextClock>(R.id.textClock)
        val timeTextEd = findViewById<EditText>(R.id.editTextTime)
        timeTextEd.setText("${txtClock?.text}")
    }
}
/*Toast.makeText(this, """$dayOfMonth - ${monthOfYear + 1} - $year""", Toast.LENGTH_LONG).show() */
//dateTextEd.setText("")
/*Toast.makeText(this, h.toString() + " : " + m , Toast.LENGTH_LONG).show()*/