package com.example.gyankunj.ui.home.mycourse.chapter

import android.content.Intent
import android.os.Bundle
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivityPhysicsChapterBinding
import com.example.gyankunj.ui.home.mycourse.CourseActivity
import com.example.gyankunj.ui.home.mycourse.adapter.CourseVideoAdapter
import com.example.gyankunj.ui.home.mycourse.chapter.adapter.PhysicsListItemAdapter
import com.example.gyankunj.ui.home.mycourse.chapter.model.PhysicsListItemModel
import com.example.gyankunj.ui.home.mycourse.chapter.topics.TopicOneActivity
import com.example.gyankunj.ui.home.mycourse.model.CourseVideosModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhysicsChapterActivity : BaseActivity<ActivityPhysicsChapterBinding,PhysicsChapterViewModel>(),CourseVideoAdapter.onItemClickListener,PhysicsListItemAdapter.onItemClickListener {
    override fun getLayoutId(): Int =R.layout.activity_physics_chapter
    override fun getViewModel(): PhysicsChapterViewModel =physicsChapterViewModel
    private val physicsChapterViewModel:PhysicsChapterViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }
    lateinit var physicsListItemAdapter: PhysicsListItemAdapter
    lateinit var courseVideoAdapter:CourseVideoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpRecyclerView()
        setUpVideoRecyclerView()
        initView()

    }

    private fun initView() {
        with(viewDataBinding){
            topAppBar.setNavigationOnClickListener {
               finish()
            }
        }
    }

    private fun setUpRecyclerView() {
        with(viewDataBinding){
            with(physicsChapterViewModel){
                physicsListItemAdapter=PhysicsListItemAdapter(this@PhysicsChapterActivity)
                listRecyclerview.adapter=physicsListItemAdapter

                var itemList=ArrayList<PhysicsListItemModel>()
                itemList.add(PhysicsListItemModel("1.","Physical Quantities"))
                itemList.add(PhysicsListItemModel("2.","Vectors"))
                itemList.add(PhysicsListItemModel("3.","Kinematics"))
                itemList.add(PhysicsListItemModel("4.","Laws of motions"))
                itemList.add(PhysicsListItemModel("5.","Gravitation"))
                itemList.add(PhysicsListItemModel("6.","Elasticity"))

                physicsListItemAdapter.addAll(itemList)

            }
        }
    }

    private fun setUpVideoRecyclerView() {
        with(viewDataBinding){
            with(physicsChapterViewModel){
                recyclerViewVideos.clipToPadding=false
                recyclerViewVideos.getChildAt(0)
                recyclerViewVideos.setPadding(50,0,50,0)
                courseVideoAdapter= CourseVideoAdapter(this@PhysicsChapterActivity)
                recyclerViewVideos.adapter=courseVideoAdapter
                var itemList=ArrayList<CourseVideosModel>()
                itemList.add(com.example.gyankunj.ui.home.mycourse.model.CourseVideosModel("Heat and thermodynamics explained in minutes"))
                itemList.add(com.example.gyankunj.ui.home.mycourse.model.CourseVideosModel("Heat and thermodynamics explained in minutes"))
                itemList.add(com.example.gyankunj.ui.home.mycourse.model.CourseVideosModel("Heat and thermodynamics explained in minutes"))
                itemList.add(com.example.gyankunj.ui.home.mycourse.model.CourseVideosModel("Heat and thermodynamics explained in minutes"))
                itemList.add(com.example.gyankunj.ui.home.mycourse.model.CourseVideosModel("Heat and thermodynamics explained in minutes"))

                courseVideoAdapter.addAll(itemList)
            }
        }
    }

    override fun onVideoClickListener(position: Int, itemList: CourseVideosModel) {

    }

    override fun onTopicsClick(position: Int, itemList: PhysicsListItemModel) {
          startActivity(Intent(this,TopicOneActivity::class.java))
    }
}