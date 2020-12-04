package com.example.gyankunj.ui.home.quiz.randomQuiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gyankunj.R

class QuizAnswerViewActivity : AppCompatActivity() {

    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mCorrectAnswers:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer_view)
        initView()


    }

    private fun initView() {

    }
}