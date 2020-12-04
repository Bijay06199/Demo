package com.example.gyankunj.ui.onBoarding

import android.content.Intent
import android.view.View
import com.example.gyankunj.base.BaseViewModel
import com.example.gyankunj.ui.auth.signIn.SignInActivity

class OnBoardingViewModel :BaseViewModel(){

    fun skip(view: View){
        Intent(view.context,SignInActivity::class.java).also {
            view.context.startActivity(it)
        }
    }
}