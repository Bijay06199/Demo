package com.example.gyankunj.utils.extentions

fun String.isValidNumber( phoneNumber:String?):Boolean{

    return android.util.Patterns.PHONE.matcher(phoneNumber).matches()
}