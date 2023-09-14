package com.example.timepicker_1

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.text.DecimalFormat
import android.icu.text.NumberFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import java.util.Calendar

//@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtView4 = findViewById<TextView>(R.id.textView4)
        val tTE = findViewById<EditText>(R.id.editTextTime)
        val dateSelBt = findViewById<Button>(R.id.btSelectDate)
        val timeSelBt = findViewById<Button>(R.id.btSelectTime)
        //val txtView4 = findViewById<TextView>(R.id.textView4)
        //val txtClock = findViewById<TextClock>(R.id.textClock)
        //val timeClk = findViewById<TextClock>(R.id.textClock)
        timeSelBt.setOnClickListener { randomTimePicker() }
        dateSelBt.setOnClickListener { datePickerDialog() }
        //tTE.addTextChangedListener() { cntDownTimer1() }

    }

    private fun cntDownTimer1() {
        val txtView4 = findViewById<TextView>(R.id.textView4)
        var hour: Long = 0
        var min: Long = 0
        var sec: Long = 33
        object : CountDownTimer(50000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                // Used for formatting digit to be in 2 digits only
                val f = DecimalFormat("00"); //NumberFormat
                hour = (millisUntilFinished / 3600000) % 24;
                min = (millisUntilFinished / 60000) % 60;
                sec = (millisUntilFinished / 1000) % 60;
                txtView4.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
            }
            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                txtView4.setText("00:00:00");
            }
        }.start();
    }
    private fun cntDownTimer() {
        // time count down for 30 seconds, with 1 second as countDown interval

        object : CountDownTimer(30000, 1000) {
            // Callback function, fired on regular interval
            val txtView4 = findViewById<TextView>(R.id.textView4)
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                txtView4.setText("seconds remaining: " + millisUntilFinished / 1000)
            }
            // Callback function, fired when the time is up
            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                txtView4.setText("done!")
            }
        }.start()
    }
    @SuppressLint("SetTextI18n")
    private fun randomTimePicker() {
        val f = DecimalFormat("00"); //NumberFormat
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR)
        val minute = c.get(Calendar.MINUTE)
        val tTE = findViewById<EditText>(R.id.editTextTime)

        val tpd = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener(function = { view, h, m  ->
            /*Toast.makeText(this, h.toString() + " : " + m , Toast.LENGTH_LONG).show()*/
            tTE.setText(f.format(h) + ":" + f.format(m))
        }),hour,minute, true)
        tpd.show()
    }
    @SuppressLint("SetTextI18n")
    private fun datePickerDialog() {
        val f = DecimalFormat("00"); //NumberFormat
        val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)
        val dTE = findViewById<EditText>(R.id.editTextDate)
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                //dTE.setText("$dayOfMonth-${monthOfYear + 1}-$year")
                dTE.setText(f.format(dayOfMonth) + "-" + f.format(monthOfYear +1)+ "-" + f.format(year))
                //Toast.makeText(this, "2 : $sDPD" , Toast.LENGTH_LONG).show()
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