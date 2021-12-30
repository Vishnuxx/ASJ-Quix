package com.example.quix

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var submitButton : Button = findViewById<Button>(R.id.button)
        var intent : Intent = Intent(this.applicationContext , QuizActivity::class.java)
        submitButton.setOnClickListener(
            View.OnClickListener {
                startActivity(intent)
            }
        )
    }


}