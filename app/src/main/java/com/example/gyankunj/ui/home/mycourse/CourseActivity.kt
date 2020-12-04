package com.example.gyankunj.ui.home.mycourse

import android.content.Intent
import android.os.Bundle
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivityPhysicsBinding
import com.example.gyankunj.ui.home.MainActivity
import com.example.gyankunj.ui.home.mycourse.adapter.CourseAdapter
import com.example.gyankunj.ui.home.mycourse.adapter.CourseVideoAdapter
import com.example.gyankunj.ui.home.mycourse.chapter.PhysicsChapterActivity
import com.example.gyankunj.ui.home.mycourse.model.CourseChapterModel
import com.example.gyankunj.ui.home.mycourse.model.CourseVideosModel
import com.example.gyankunj.ui.home.quiz.randomQuiz.Constants
import org.koin.androidx.viewmodel.ext.android.viewModel

class CourseActivity : BaseActivity<ActivityPhysicsBinding,CourseViewModel>(),CourseAdapter.onItemClickListener,CourseVideoAdapter.onItemClickListener {
    override fun getLayoutId(): Int =R.layout.activity_physics
    override fun getViewModel(): CourseViewModel =courseViewModel
    private val courseViewModel:CourseViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }
    lateinit var courseAdapter: CourseAdapter
    lateinit var courseVideoAdapter: CourseVideoAdapter
    var item:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpChapterRecyclerView()
        setUpVideoRecyclerView()
        item=intent.getStringExtra(Constants.ITEM)
        initView()

    }

    private fun setUpVideoRecyclerView() {
        with(viewDataBinding){
            with(courseViewModel){
                recyclerViewVideos.clipToPadding=false
                recyclerViewVideos.getChildAt(0)
                recyclerViewVideos.setPadding(50,0,50,0)
                courseVideoAdapter= CourseVideoAdapter(this@CourseActivity)
                recyclerViewVideos.adapter=courseVideoAdapter
                var itemList=ArrayList<CourseVideosModel>()
                itemList.add(CourseVideosModel("Heat and thermodynamics explained in minutes"))
                itemList.add(CourseVideosModel("Heat and thermodynamics explained in minutes"))
                itemList.add(CourseVideosModel("Heat and thermodynamics explained in minutes"))
                itemList.add(CourseVideosModel("Heat and thermodynamics explained in minutes"))
                itemList.add(CourseVideosModel("Heat and thermodynamics explained in minutes"))

                courseVideoAdapter.addAll(itemList)
            }
        }
    }

    private fun initView() {
        with(viewDataBinding){


            tvCourseName.text=item
            topAppBar.setNavigationOnClickListener {
                finish()
            }
        }
    }

    private fun setUpChapterRecyclerView() {
        with(viewDataBinding){
            with(courseViewModel){
                courseAdapter= CourseAdapter(this@CourseActivity)
                chaptersRecyclerView.adapter=courseAdapter
                var itemList=ArrayList<CourseChapterModel>()
                itemList.add(CourseChapterModel("1","Introduction to Mechanics"))
                itemList.add(CourseChapterModel("2","Heat and Thermodynamics"))
                itemList.add(CourseChapterModel("3","Geometrical Optics"))
                itemList.add(CourseChapterModel("4","Electrostatics"))
                itemList.add(CourseChapterModel("5","Electrostatics"))
                itemList.add(CourseChapterModel("6","Electrostatics"))
                itemList.add(CourseChapterModel("7","Electrostatics"))

                courseAdapter.addAll(itemList)
            }
        }
    }

    override fun onChapterClickListener(position: Int, itemList: CourseChapterModel) {
         startActivity(Intent(this,PhysicsChapterActivity::class.java))
    }

    override fun onVideoClickListener(position: Int, itemList: CourseVideosModel) {

    }
}