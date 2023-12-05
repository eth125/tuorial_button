
package com.example.button

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "TextContent"

class MainActivity : AppCompatActivity() {

    private var textView: TextView? = null
//    private var numTimesClicked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"onCreate:called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput:EditText = findViewById<EditText>(R.id.editText)
        val button:Button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)
        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()
        userInput.setText("")


        button.setOnClickListener (object: View.OnClickListener  {
            override fun onClick(p0: View?) {
                Log.d(TAG,"onClick: called")
//                numTimesClicked+=1
//                textView?.append("\nThe button got tapped $numTimesClicked")
//                if(numTimesClicked != 1)
//                {
//                    textView?.append("s\n")
//                }
//                else
//                {
//                    textView?.append("\n")
//                }
                textView?.append(userInput.text)
                textView?.append("\n")
                userInput.setText("")
            }
        })
    }

    override fun onStart() {
        Log.d(TAG,"onStart:called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG,"onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
//        /*retrive/restore saved content from fun onSaveInstanceState(outState: Bundle)*/
//        val saveString = savedInstanceState?.getString(TEXT_CONTENTS,"")
//        textView?.text = saveString
        textView?.text = savedInstanceState?.getString(TEXT_CONTENTS,"")
    }

    override fun onResume() {
        Log.d(TAG,"onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG,"onPause")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG,"onSaveInstanceState")
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENTS,textView?.text.toString())
        /*save the text content*/
    }

    override fun onStop() {
        Log.d(TAG,"onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG,"onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy")
        super.onDestroy()
    }
}
