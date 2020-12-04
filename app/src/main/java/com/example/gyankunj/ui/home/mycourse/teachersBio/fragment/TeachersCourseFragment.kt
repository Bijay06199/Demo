package com.example.gyankunj.ui.home.mycourse.teachersBio.fragment

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.FragmentActivity
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseFragment
import com.example.gyankunj.databinding.FragmentTeachersCourseBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class TeachersCourseFragment : BaseFragment<FragmentTeachersCourseBinding,TeachersCourseViewModel>() {
    override fun getLayoutId(): Int =R.layout.fragment_teachers_course
    override fun getViewModel(): TeachersCourseViewModel =teachersCourseViewModel
    private val teachersCourseViewModel:TeachersCourseViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListView()
    }

    private fun setUpListView() {
        with(teachersCourseViewModel){
            with(viewDataBinding){
                var courseList= arrayListOf("Heat and Thermodynamics","Geometrical Optics","Electrostatics",
                "Electricity","Light","Gravity","Force")

                var listItems= arrayOfNulls<String>(courseList.size)

                for (i in 0 until courseList.size){
                    val course=courseList[i]
                    listItems[i]=course
                }

                val adapter=
                    ArrayAdapter(requireContext(),R.layout.teacher_course_list_item,listItems)
                listRecyclerview.adapter=adapter

            }
        }
    }

    companion object {
        val TAG=TeachersCourseFragment::class.java.simpleName
        fun start(activity: FragmentActivity, containerId:Int){
            val fragment=TeachersCourseFragment()
            activity.supportFragmentManager.beginTransaction()
                .addToBackStack(TAG)
                .replace(containerId,fragment)
                .commit()
        }
    }
}