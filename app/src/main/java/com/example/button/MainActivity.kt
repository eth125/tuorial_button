package com.example.button

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var userInput: EditText?=null
    private var button : Button? = null
    private var textView: TextView? = null
    private var numTimesClicked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userInput = findViewById<EditText>(R.id.editText)
        button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView2)
        textView?.text = ""


        button?.setOnClickListener { object: View.OnClickListener {
            override fun onClick(v: View?) {
                numTimesClicked+=1
                textView?.append("\nThe button got tapped $numTimesClicked")
                if(numTimesClicked != 1)
                {
                    textView?.append("s\n")
                }
                else
                {
                    textView?.append("\n")
                }
            }
        }}
    }
}