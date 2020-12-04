package com.example.gyankunj.ui.onBoarding

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.get
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager2.widget.ViewPager2
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivityOnBoardingBinding
import com.example.gyankunj.ui.home.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class OnBoardingActivity : BaseActivity<ActivityOnBoardingBinding, OnBoardingViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_on_boarding
    override fun getViewModel(): OnBoardingViewModel = onBoardingViewModel
    private val onBoardingViewModel: OnBoardingViewModel by viewModel()

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


     val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlide(
                "Learn from the best",
                  R.drawable.onboarding1
            ),

            IntroSlide(
              "Download and learn anytime",
                R.drawable.onboading2
            ),

            IntroSlide(
               "Explore a range of topic",
                R.drawable.onboarding3
            )
        )
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()

    }

    private fun initView() {
        with(viewDataBinding) {

           viewPager.adapter=introSliderAdapter
            setUpIndicators()
            setCurrentIndicator(0)
            viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    setCurrentIndicator(position)
                }
            })
        }

    }

    private fun setUpIndicators() {
        with(viewDataBinding){
            var indicators= arrayOfNulls<ImageView>(introSliderAdapter.itemCount)

            val layoutParams:LinearLayout.LayoutParams=
                LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            layoutParams.setMargins(8,0,8,0)
            for (i in indicators.indices){
                indicators[i]= ImageView(applicationContext)
                indicators[i].apply {
                    this?.setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.indicator_inactive
                        )
                    )
                    this?.layoutParams=layoutParams
                }
                layoutIndicators.addView(indicators[i])
            }
        }
    }


    fun setCurrentIndicator(index:Int){
        with(viewDataBinding){
            val childCount=layoutIndicators.childCount
            for(i in 0 until childCount){
                val imageView=layoutIndicators.get(i) as ImageView
                if (i==index){
                    imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.indicator_active
                        )
                    )
                }else{
                    imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.indicator_inactive
                        )
                    )
                }
            }
        }

    }


}

