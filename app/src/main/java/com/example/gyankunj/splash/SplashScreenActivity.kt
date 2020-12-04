package com.example.gyankunj.splash

import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivitySplashScreenBinding
import com.example.gyankunj.ui.home.MainActivity
import com.example.gyankunj.ui.onBoarding.OnBoardingActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashScreenActivity : BaseActivity<ActivitySplashScreenBinding,SplashViewModel>() {

    override fun getLayoutId(): Int =R.layout.activity_splash_screen
    override fun getViewModel(): SplashViewModel =splashViewModel
    private val splashViewModel:SplashViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var animation=AnimationUtils.loadAnimation(this,R.anim.zoom_in_out)
        animation.setInterpolator(LinearInterpolator())
        initView()
        hideView()
        splash_imageView.startAnimation(animation)



        Handler().postDelayed({
            if (preferenceManager.getLogged()){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            else{
                startActivity(Intent(this,OnBoardingActivity::class.java))
                finish()
            }

        },3500)

        splash_imageView.postDelayed({

            splash_imageView.visibility=View.INVISIBLE
           ObjectAnimator.ofFloat(splash_imageView,"translationX",1000f).apply {
               duration=1000
               start()
           }
            splash_textView.visibility=View.VISIBLE


        },2000)

    }

    private fun initView() {




    }


    private fun hideView() {
        splash_textView.visibility= View.INVISIBLE
    }
}