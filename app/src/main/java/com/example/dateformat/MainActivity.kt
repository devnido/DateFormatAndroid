package com.example.dateformat

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.joestelmach.natty.Parser
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.util.*


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

            val parser = Parser()
            val groups = parser.parse(textInputLayout.editText?.text.toString())
            var date: Date? = null

            groups.map {
                Log.d("TAG_DATE", it.dates.toString())
                date = it.dates[0]
            }

            textView.text = date.toString()

        }catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }

    }

}