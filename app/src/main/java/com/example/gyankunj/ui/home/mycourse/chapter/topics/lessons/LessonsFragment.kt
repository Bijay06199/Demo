package com.example.gyankunj.ui.home.mycourse.chapter.topics.lessons

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseFragment
import com.example.gyankunj.databinding.FragmentLessonsBinding
import com.example.gyankunj.ui.home.mycourse.chapter.model.PhysicsListItemModel
import com.example.gyankunj.ui.home.mycourse.chapter.topics.lessons.activity.LessonContentActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class LessonsFragment : BaseFragment<FragmentLessonsBinding,LessonsViewModel>(),LessonsAdapter.onItemClickListener {
    override fun getLayoutId(): Int = R.layout.fragment_lessons
    override fun getViewModel(): LessonsViewModel=lessonsViewModel
    private val lessonsViewModel:LessonsViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }
    lateinit var lessonsAdapter: LessonsAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        with(viewDataBinding){
            with(lessonsViewModel){
                lessonsAdapter= LessonsAdapter(this@LessonsFragment)
                listRecyclerview.adapter=lessonsAdapter
                var itemList=ArrayList<PhysicsListItemModel>()

                itemList.add(PhysicsListItemModel("1.","Dimensions"))
                itemList.add(PhysicsListItemModel("2.","Units"))
                itemList.add(PhysicsListItemModel("3.","Quantities"))
                itemList.add(PhysicsListItemModel("4.","Scalars"))
                itemList.add(PhysicsListItemModel("5.","Vectors"))
                itemList.add(PhysicsListItemModel("6.","Dimensions"))
                lessonsAdapter.addAll(itemList)

            }
        }
    }


    companion object {
       val TAG=LessonsFragment::class.java.simpleName

        fun start(activity: FragmentActivity,containerId:Int){
            val fragment=LessonsFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(TAG)
                .commit()
        }

    }

    override fun onLessonsClick(position: Int, itemModel: PhysicsListItemModel) {
        startActivity(Intent(requireContext(),LessonContentActivity::class.java))

    }
}