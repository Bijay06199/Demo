package com.example.gyankunj.utils.extentions

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.andrognito.flashbar.Flashbar
import com.example.gyankunj.R

fun ProgressBar.show(){
    visibility= View.VISIBLE
}

fun ProgressBar.hide(){
    visibility= View.INVISIBLE
}

fun TextView.showText(){
    visibility= View.VISIBLE
}

fun TextView.hideText(){
    visibility= View.INVISIBLE
}

fun Context.showToast(message: String){
    Toast.makeText(this,message, Toast.LENGTH_LONG).show()
}

fun Activity.successFlashBar(message:String):Flashbar{

    return Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .message(message)
        .backgroundColor(resources.getColor(R.color.success))
        .duration(500)
        .titleSizeInPx(12f)
        .build()
}

fun Activity.infoFlashBar(message:String):Flashbar{

    return Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .message(message)
        .backgroundColor(resources.getColor(R.color.info))
        .duration(500)
        .titleSizeInPx(12f)
        .build()
}

fun Activity.warningFlashBar(message:String):Flashbar{

    return Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .message(message)
        .backgroundColor(resources.getColor(R.color.warning))
        .duration(500)
        .titleSizeInPx(12f)
        .build()
}

fun Activity.dangerFlashBar(message:String):Flashbar{

    return Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .message(message)
        .backgroundColor(resources.getColor(R.color.danger))
        .duration(500)
        .titleSizeInPx(12f)
        .build()
}