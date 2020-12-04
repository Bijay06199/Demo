package com.example.gyankunj.ui.home.mycourse.chapter.topics.info

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseFragment
import com.example.gyankunj.databinding.FragmentInfoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class InfoFragment :BaseFragment<FragmentInfoBinding,InfoViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_info
    override fun getViewModel(): InfoViewModel =infoViewModel
    private val infoViewModel:InfoViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }




    companion object {
        fun start(activity: FragmentActivity,containerId:Int){
            val fragment=InfoFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack("TAG")
                .commit()
        }

    }
}