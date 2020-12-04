package com.example.gyankunj.ui.home.mycourse.chapter.topics.viewModel

import android.content.Intent
import android.view.View
import com.example.gyankunj.base.BaseViewModel
import com.example.gyankunj.ui.home.mycourse.teachersBio.TeachersProfileActivity

class TopicOneViewModel :BaseViewModel(){

    fun teacherProfile(view:View){
        Intent(view.context,TeachersProfileActivity::class.java).also {
            view.context.startActivity(it)
        }
    }
}