package com.example.gyankunj.ui.home.quiz

import android.content.Intent
import android.os.Bundle
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivityQuizBinding
import com.example.gyankunj.ui.home.MainActivity
import com.example.gyankunj.ui.home.quiz.adapter.QuizAdapter
import com.example.gyankunj.ui.home.quiz.model.QuizModel
import com.example.gyankunj.ui.home.quiz.randomQuiz.RandomQuizActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuizActivity : BaseActivity<ActivityQuizBinding,QuizViewModel>(),QuizAdapter.onItemClickListener {
    override fun getLayoutId(): Int =R.layout.activity_quiz
    override fun getViewModel(): QuizViewModel =quizViewModel
    private val quizViewModel:QuizViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }
    lateinit var quizAdapter: QuizAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpSubjectRecyclerView()
        initView()

    }

    private fun initView() {
        with(viewDataBinding){
            topAppBar.setNavigationOnClickListener {
               finish()
            }
        }
    }

    private fun setUpSubjectRecyclerView() {
        with(viewDataBinding){
            with(quizViewModel){
                quizAdapter= QuizAdapter(this@QuizActivity)
                recyclerviewCourse.adapter=quizAdapter
                var itemList=ArrayList<QuizModel>()

                itemList.add(QuizModel(R.drawable.ic_calculator,"Mathematics"))
                itemList.add(QuizModel(R.drawable.ic_lab,"Chemistry"))
                itemList.add(QuizModel(R.drawable.ic_gear,"Physics"))
                itemList.add(QuizModel(R.drawable.ic_dna,"Biology"))
                itemList.add(QuizModel(R.drawable.ic_laptop,"Computer"))
                itemList.add(QuizModel(R.drawable.ic_transfer,"Management"))

                quizAdapter.addAll(itemList)
            }
        }
    }

    override fun onCourseClickListener(position: Int, itemList: QuizModel) {
          startActivity(Intent(this,RandomQuizActivity::class.java))
    }


}