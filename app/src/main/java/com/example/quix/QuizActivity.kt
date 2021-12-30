package com.example.quix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class QuizActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        initializeLogic()
    }

    fun initializeLogic() {
        //Question
        var questionText: TextView = findViewById(R.id.question)
        var score : TextView = findViewById(R.id.points)
        //options
        var optionA: RadioButton = findViewById(R.id.optA)
        var optionB: RadioButton = findViewById(R.id.optB)
        var optionC: RadioButton = findViewById(R.id.optC)
        var optionD: RadioButton = findViewById(R.id.optD)
        //submitButton
        var submit : Button = findViewById(R.id.submitButton)


        var questionBank = ArrayList<Question>()
        var points = 0
        var questionNumber = 0
        var currentQuestion : Question? = null
        var selectedAnswer : String = ""




        fun refreshRadioButtons() {
            optionA.setChecked(false)
            optionB.setChecked(false)
            optionC.setChecked(false)
            optionD.setChecked(false)
        }

        fun checkLastQuestionOnSubmit() {
            if(questionNumber >= questionBank.size) {
                var intent: Intent = Intent(this.applicationContext , ResultActivity::class.java )
                intent.putExtra("score" , points.toString())
                startActivity(intent)
            }
        }

        fun isCorrect(value: String , question: Question?) : Boolean {
            var answer = question!!.answer.toString()
            return value.equals(answer)
        }



        fun initQuestionBank() {

            questionBank.add(
                Question("what is this" ,
                    "pen",
                    "pencil",
                    "erazer" ,
                    "scale" ,
                    "scale")
            )

            questionBank.add(
                Question("what is this second question" ,
                    "pen",
                    "pencil",
                    "erazer" ,
                    "scale" ,
                    "scale")
            )

            currentQuestion = questionBank.get(questionNumber)
            questionText.setText(currentQuestion!!.question)
        }

        fun loadQuestion(ques : Question) {
            questionText.text = ques.question.toString()
            optionA.text = ques.optA.toString()
            optionB.text = ques.optB.toString()
            optionC.text = ques.optC.toString()
            optionD.text = ques.optD.toString()
        }


        fun clickOption() {
            optionA.setOnClickListener {
                refreshRadioButtons()
                optionA.setChecked(true)
                selectedAnswer = optionA.text.toString()
            }

            optionB.setOnClickListener {
                refreshRadioButtons()
                optionB.setChecked(true)
                selectedAnswer = optionB.text.toString()
            }

            optionC.setOnClickListener {
                refreshRadioButtons()
                optionC.setChecked(true)
                selectedAnswer = optionC.text.toString()
            }
            optionD.setOnClickListener {
                refreshRadioButtons()
                optionD.setChecked(true)
                selectedAnswer = optionD.text.toString()
            }

            submit.setOnClickListener {

                if (isCorrect(selectedAnswer , currentQuestion)) {
                    refreshRadioButtons()
                    points = points + 5
                    score.text = "Points: " + points
                    questionNumber++
                    checkLastQuestionOnSubmit()
                    currentQuestion = questionBank.get(questionNumber)
                    loadQuestion(currentQuestion!!)
                }
            }
        }


        initQuestionBank()
        loadQuestion(questionBank.get(questionNumber))
        clickOption()

    }

}







data class Question(
    var question: String ,
    var optA : String ,
    var optB : String ,
    var optC : String ,
    var optD : String ,
    var answer : String )
