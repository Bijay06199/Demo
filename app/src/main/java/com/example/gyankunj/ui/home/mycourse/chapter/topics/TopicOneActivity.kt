package com.example.gyankunj.ui.home.mycourse.chapter.topics

import android.content.Intent
import android.os.Bundle
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivityTopicOneBinding
import com.example.gyankunj.ui.home.mycourse.chapter.PhysicsChapterActivity
import com.example.gyankunj.ui.home.mycourse.chapter.topics.formulas.FormulaFragment
import com.example.gyankunj.ui.home.mycourse.chapter.topics.info.InfoFragment
import com.example.gyankunj.ui.home.mycourse.chapter.topics.lessons.LessonsFragment
import com.example.gyankunj.ui.home.mycourse.chapter.topics.viewModel.TopicOneViewModel
import com.google.android.material.tabs.TabLayout
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopicOneActivity : BaseActivity<ActivityTopicOneBinding,TopicOneViewModel>() {
    override fun getLayoutId(): Int =R.layout.activity_topic_one
    override fun getViewModel(): TopicOneViewModel =topicOneViewModel
    private val topicOneViewModel:TopicOneViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InfoFragment.start(this,R.id.frame_layout_lessons)
        initView()
    }

    private fun initView() {
        with(viewDataBinding){
            topAppBar.setNavigationOnClickListener {
               finish()
            }
            tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabSelected(tab: TabLayout.Tab?) {
                   when(tab?.position){
                       0->InfoFragment.start(this@TopicOneActivity,R.id.frame_layout_lessons)
                       1-> LessonsFragment.start(this@TopicOneActivity,R.id.frame_layout_lessons)
                       2-> FormulaFragment.start(this@TopicOneActivity,R.id.frame_layout_lessons)
                   }
                }


            })
        }
    }
    override fun onBackPressed() {
        var currenFragment=supportFragmentManager.findFragmentById(R.id.frame_layout_lessons)
        if (currenFragment is InfoFragment){
            finish()
        }

        else{
            super.onBackPressed()
            finish()
        }
    }
}