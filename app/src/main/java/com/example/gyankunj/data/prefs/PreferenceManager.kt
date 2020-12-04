package com.example.gyankunj.data.prefs

interface PreferenceManager {
    fun setNumber(isNumber:String?)
    fun getNumber():String?

    fun setLogged(isLogged:Boolean)
    fun getLogged():Boolean

    fun setOTP(isOTP:String?)
    fun getOTP():String?
}