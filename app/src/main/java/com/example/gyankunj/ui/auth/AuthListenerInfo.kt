package com.example.gyankunj.ui.auth

interface AuthListenerInfo {

    fun onSuccess(message:String)

    fun onStarted()

    fun onInfo(message: String)

    fun onWarning(message: String)

    fun onDanger(message: String)
}