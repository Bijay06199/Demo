package com.example.gyankunj.ui.home.quiz.randomQuiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivityRandomQuizBinding
import com.example.gyankunj.ui.home.quiz.QuizActivity
import com.google.android.material.card.MaterialCardView
import com.google.android.material.checkbox.MaterialCheckBox
import org.koin.androidx.viewmodel.ext.android.viewModel

class RandomQuizActivity : BaseActivity<ActivityRandomQuizBinding,RandomQuizViewModel>(),View.OnClickListener {
    override fun getLayoutId(): Int =R.layout.activity_random_quiz
    override fun getViewModel(): RandomQuizViewModel=randomQuizViewModel
    private val randomQuizViewModel:RandomQuizViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }
    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAnswers:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        setQuestions()

    }

    private fun initView() {
        with(viewDataBinding){
            topAppBar.setNavigationOnClickListener {
                popUpWindow(rootLayout,rootLayout,R.layout.quiz_exit_popup)
                var clNo=layoutView?.findViewById<ConstraintLayout>(R.id.cl_no)
                var clYes=layoutView?.findViewById<ConstraintLayout>(R.id.cl_yes)
                var tvYes=layoutView?.findViewById<TextView>(R.id.tv_yes)
                var tvNo=layoutView?.findViewById<TextView>(R.id.tv_no)

                clYes?.setOnClickListener {
                    clYes.setBackgroundResource(R.drawable.selected_quiz_exit_color)
                    clNo?.setBackgroundResource(R.drawable.yes_no_button_color)
                    tvYes?.setTextColor(resources.getColor(R.color.white))
                    tvNo?.setTextColor(resources.getColor(R.color.onboarding_button_color))
                    startActivity(Intent(this@RandomQuizActivity,QuizActivity::class.java))

                }

                clNo?.setOnClickListener {
                    clYes?.setBackgroundResource(R.drawable.yes_no_button_color)
                    clNo.setBackgroundResource(R.drawable.selected_quiz_exit_color)
                    tvYes?.setTextColor(resources.getColor(R.color.onboarding_button_color))
                    tvNo?.setTextColor(resources.getColor(R.color.white))
                    popupWindow?.dismiss()

                }

            }

            mQuestionList=Constants.getQuestions()
            cb1.setOnClickListener(this@RandomQuizActivity)
            cb2.setOnClickListener(this@RandomQuizActivity)
            cb3.setOnClickListener(this@RandomQuizActivity)
            cb4.setOnClickListener(this@RandomQuizActivity)
            btnNext.setOnClickListener(this@RandomQuizActivity)




        }
    }

    private fun setQuestions(){
        with(viewDataBinding){



            val question= mQuestionList!![mCurrentPosition-1]

            defaultOptionsView()

            progressBar.progress=mCurrentPosition
            progressBar.max=mQuestionList!!.size
            tvQuestionsNo.text="$mCurrentPosition" + " "+ "of" +" "+ progressBar.max

            tvQuestions.text=question!!.question
            cb1.text=question.optionOne
            cb2.text=question.optionTwo
            cb3.text=question.optionThree
            cb4.text=question.optionFour
        }

    }

    private fun defaultOptionsView(){
        with(viewDataBinding){

            val options=ArrayList<MaterialCheckBox>()

            options.add(0,cb1)
            options.add(1,cb2)
            options.add(2,cb3)
            options.add(3,cb4)

            for (option in options){
                option.isChecked=false
                option.background=ContextCompat.getDrawable(this@RandomQuizActivity,R.drawable.selected_checkbox_stroke_background)
                option.setCompoundDrawablesWithIntrinsicBounds(R.drawable.custom_checkbox,0,0,0)
            }
        }


    }

    fun selectedOptionView(cb:MaterialCheckBox,selectedOptionNum:Int){
      with(viewDataBinding){

          defaultOptionsView()
          mSelectedOptionPosition=selectedOptionNum

          cb.isChecked=true
      }

    }

    private fun answerView(answer:Int,drawableView:Int,drawableLeft:Int,drawableRight:Int){
        with(viewDataBinding){
            when(answer){
                1->{
                  cb1.background=ContextCompat.getDrawable(this@RandomQuizActivity,drawableView)
                    cb1.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,0,drawableRight,0)

                }
                2->{
                    cb2.background=ContextCompat.getDrawable(this@RandomQuizActivity,drawableView)
                    cb1.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,0,drawableRight,0)

                }
                3->{
                    cb3.background=ContextCompat.getDrawable(this@RandomQuizActivity,drawableView)
                    cb1.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,0,drawableRight,0)

                }
                4->{
                    cb4.background=ContextCompat.getDrawable(this@RandomQuizActivity,drawableView)
                    cb1.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,0,drawableRight,0)

                }
            }
        }

    }





    override fun onClick(v: View?) {
        with(viewDataBinding){
            when(v?.id){
                R.id.cb_1->{
                    selectedOptionView(cb1,1)
                }

                R.id.cb_2->{
                    selectedOptionView(cb2,2)
                }
                R.id.cb_3->{
                    selectedOptionView(cb3,3)
                }
                R.id.cb_4->{
                    selectedOptionView(cb4,4)
                }

                R.id.btn_next->{


                    if (mSelectedOptionPosition!=0){
                        mCurrentPosition++

                        when{
                            mCurrentPosition<= mQuestionList!!.size->{

                                    setQuestions()





                            }else->{
                            popUpWindow(
                                rootLayout,
                                rootLayout,
                                com.example.gyankunj.R.layout.quiz_popup_layout
                            )
                            var playAgain =
                                layoutView?.findViewById<AppCompatButton>(com.example.gyankunj.R.id.btn_play_again)

                            var checkAnswer=layoutView?.findViewById<MaterialCardView>(R.id.cv_check_answer)
                            var tvScore=layoutView?.findViewById<TextView>(R.id.tv_score)

                            checkAnswer?.setOnClickListener {

                                mCurrentPosition=1

                                if (mCurrentPosition<=mQuestionList!!.size){

                                    mQuestionList!!.forEach { i ->

                                        mCurrentPosition++
                                        tvQuestionsNo.text="$mCurrentPosition"
                                        tvQuestions.text=i.question
                                        cb1.text=i.optionOne
                                        cb2.text=i.optionTwo
                                        cb3.text=i.optionThree
                                        cb4.text=i.optionFour
                                    }
                                    progressBar.progress=mCurrentPosition
                                    tvQuestionsNo.text="$mCurrentPosition"


                                }
                                popupWindow?.dismiss()

                                btnNext.visibility=View.GONE
                                progressBar.visibility=View.GONE

                                val question=mQuestionList?.get(mCurrentPosition-2)
                                if (question!!.correctAnswer!=mSelectedOptionPosition){
                                    answerView(mSelectedOptionPosition,R.drawable.selected_checkbox_strok_error,R.drawable.custom_checkbox_errorr,0)
                                }
                                answerView(question.correctAnswer,R.drawable.selected_checkbox_stroke_background,R.drawable.custom_checkbox,R.drawable.tick)


                            }


                            playAgain?.setOnClickListener {
                                startActivity(Intent(this@RandomQuizActivity,QuizActivity::class.java))


                            }


                            tvScore?.text="$mCorrectAnswers"+ "/"+progressBar.max
                           }
                        }

                        val question=mQuestionList?.get(mCurrentPosition-2)
                        if (question!!.correctAnswer!=mSelectedOptionPosition){
                            answerView(mSelectedOptionPosition,R.drawable.selected_checkbox_strok_error,R.drawable.custom_checkbox_errorr,0)

                        }
                        else{
                            mCorrectAnswers++
                        }

                        if (mCurrentPosition==mQuestionList!!.size){

                            btnNext.text="Finish"
                        }else{
                            btnNext.text="Next questions"
                        }

                    }
                    mSelectedOptionPosition=0

                }

            }
        }

    }




}