package com.example.gyankunj.ui.home.mycourse.chapter.topics.lessons.activity

import android.os.Bundle
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivityLessonContentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LessonContentActivity : BaseActivity<ActivityLessonContentBinding,LessonContentViewModel>() {
    override fun getLayoutId(): Int =R.layout.activity_lesson_content
    override fun getViewModel(): LessonContentViewModel =lessonContentViewModel
    private val lessonContentViewModel:LessonContentViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       initView()
    }

    private fun initView() {
        with(viewDataBinding){

            topAppBar.setNavigationOnClickListener {
              finish()
            }
        }
    }
}