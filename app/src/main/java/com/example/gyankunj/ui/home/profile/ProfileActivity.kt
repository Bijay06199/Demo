package com.example.gyankunj.ui.home.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivityProfileBinding
import com.example.gyankunj.ui.home.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileActivity : BaseActivity<ActivityProfileBinding,ProfileViewModel>() {
    override fun getLayoutId(): Int =R.layout.activity_profile
    override fun getViewModel(): ProfileViewModel =profileViewModel
    private val profileViewModel:ProfileViewModel by viewModel()
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