package com.example.dateformat

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.ISODateTimeFormat
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            validateDate()
        }

    }

    private fun validateDate(){

        try {
            val date = textInputLayout.editText?.text

            val fmt: DateTimeFormatter = ISODateTimeFormat.dateTime()

            val dt = fmt.parseDateTime(date.toString())

            val outputDate = fmt.print(dt);

            textView.text = outputDate
        }catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }



    }

}