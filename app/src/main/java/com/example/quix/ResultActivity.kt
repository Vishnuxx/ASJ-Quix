package com.example.quix

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        initializeLogic()
    }

    private fun initializeLogic() {
        try {


            val scoreboard: TextView = findViewById(R.id.scoreboard)

            val score = intent.getStringExtra("score").toString()
            scoreboard.text = "$score/50"

            val returnButton: Button = findViewById(R.id.returnButton)
            returnButton.setOnClickListener {
                val intent = Intent(this.applicationContext, MainActivity::class.java)
                startActivity(intent)
            }

        }catch (e : Exception) {
            Log.e(TAG, "initializeLogic: $e")
        }
    }
}