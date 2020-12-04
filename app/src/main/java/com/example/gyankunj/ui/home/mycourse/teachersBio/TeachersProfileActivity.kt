package com.example.gyankunj.ui.home.mycourse.teachersBio

import android.content.Intent
import android.os.Bundle
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivityTeachersProfileBinding
import com.example.gyankunj.ui.home.mycourse.chapter.topics.TopicOneActivity
import com.example.gyankunj.ui.home.mycourse.teachersBio.fragment.TeachersBioFragment
import com.example.gyankunj.ui.home.mycourse.teachersBio.fragment.TeachersCourseFragment
import com.google.android.material.tabs.TabLayout
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeachersProfileActivity : BaseActivity<ActivityTeachersProfileBinding,TeachersProfileViewModel>() {
    override fun getLayoutId(): Int =R.layout.activity_teachers_profile
    override fun getViewModel(): TeachersProfileViewModel=teachersProfileViewModel
    private val teachersProfileViewModel:TeachersProfileViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TeachersBioFragment.start(this,R.id.frame_layout_teachers_profile)
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
                        0->TeachersBioFragment.start(this@TeachersProfileActivity,R.id.frame_layout_teachers_profile)
                        1-> TeachersCourseFragment.start(this@TeachersProfileActivity,R.id.frame_layout_teachers_profile)
                    }
                }


            })
        }
    }

    override fun onBackPressed() {
        var currentFragment=supportFragmentManager.findFragmentById(R.id.frame_layout_teachers_profile)
        if (currentFragment is TeachersBioFragment){
            finish()
        }

        else{
            super.onBackPressed()
            finish()
        }
    }
}