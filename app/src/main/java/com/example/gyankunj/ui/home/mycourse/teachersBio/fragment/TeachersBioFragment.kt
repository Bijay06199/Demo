package com.example.gyankunj.ui.home.mycourse.teachersBio.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseFragment
import com.example.gyankunj.databinding.FragmentTeachersBioBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class TeachersBioFragment : BaseFragment<FragmentTeachersBioBinding,TeachersBioViewModel>() {
    override fun getLayoutId(): Int =R.layout.fragment_teachers_bio
    override fun getViewModel(): TeachersBioViewModel =teachersViewModel
    private val teachersViewModel:TeachersBioViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        val TAG=TeachersBioFragment::class.java.simpleName
        fun start(activity: FragmentActivity,containerId:Int){
            val fragment=TeachersBioFragment()
            activity.supportFragmentManager.beginTransaction()
                .addToBackStack(TAG)
                .replace(containerId,fragment)
                .commit()
        }

    }
}