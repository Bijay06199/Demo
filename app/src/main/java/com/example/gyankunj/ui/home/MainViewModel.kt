package com.example.gyankunj.ui.home

import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.gyankunj.base.BaseViewModel
import com.example.gyankunj.data.repositories.CreateBannerRepository
import com.example.gyankunj.data.repositories.GetBannerRepository
import com.example.gyankunj.data.repositories.GetCourseRepository
import com.example.gyankunj.ui.auth.AuthListenerInfo
import com.example.gyankunj.ui.home.api.BannerResponse
import com.example.gyankunj.ui.home.mycourse.CourseActivity
import com.example.gyankunj.ui.home.noticeBoard.NoticeBoardActivity
import com.example.gyankunj.ui.home.quiz.QuizActivity
import com.example.gyankunj.utils.NoInternetException
import com.example.gyankunj.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class MainViewModel(private val createBannerRepository: CreateBannerRepository,private val getBannerRepository: GetBannerRepository,private val getCourseRepository: GetCourseRepository):BaseViewModel() {

    var bannerEvent=SingleLiveEvent<Unit>()
    var courseEvent=SingleLiveEvent<Unit>()
    var itemsBanner:BannerResponse?=null

    var itemsCourse: BannerResponse?=null
    var authListenerInfo:AuthListenerInfo?=null
    var quizClickedEvent=SingleLiveEvent<Unit>()



    fun banner(){

     viewModelScope.launch {

         try {
             val response=getBannerRepository.getBanner()
             itemsBanner=response.body()!!


             bannerEvent.call()
         }catch (e:NoInternetException){
             authListenerInfo?.onWarning(e.message!!)
         }

     }
    }

    fun course(){
        viewModelScope.launch {
            try {
                val response=getCourseRepository.getCourse()
                itemsCourse=response.body()
                courseEvent.call()
            }catch (e:NoInternetException){
                authListenerInfo?.onWarning(e.message!!)

            }

        }
    }

    fun quiz(view: View){
        Intent(view.context,QuizActivity::class.java).also {
            view.context.startActivity(it)
        }

    }





    fun noticeBoard(view: View){
        Intent(view.context,NoticeBoardActivity::class.java).also {
            view.context.startActivity(it)
        }
    }


}