package com.example.gyankunj.ui.auth.forgotPassword

import android.view.View
import androidx.lifecycle.viewModelScope
import com.example.gyankunj.base.BaseViewModel
import com.example.gyankunj.data.repositories.ForgotPasswordRepository
import com.example.gyankunj.ui.auth.AuthListenerInfo
import com.example.gyankunj.utils.NoInternetException
import com.example.gyankunj.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.ConnectException

class ForgotPasswordFinalViewModel(private val forgotPasswordRepository: ForgotPasswordRepository) :BaseViewModel(){
    var authListenerInfo:AuthListenerInfo?=null
    var textNewPassword:String?=null
    var textConfirmPassword:String?=null
    var nextClickedEvent=SingleLiveEvent<Unit>()

    var phone=forgotPasswordRepository.preferenceManager.getNumber()
    var otp=forgotPasswordRepository.preferenceManager.getOTP()

    fun next(){
        if (textNewPassword.isNullOrEmpty()){
            authListenerInfo?.onInfo("Please enter new password")
        }
        else if (textConfirmPassword.isNullOrEmpty()){
            authListenerInfo?.onInfo("Please enter confirm password")
        }
        else if (textNewPassword!=textConfirmPassword){
            authListenerInfo?.onWarning("Password doesnot match")
        }
        else{
           viewModelScope.launch {
               authListenerInfo?.onStarted()
               try {
                   var response=forgotPasswordRepository.userResetPassword(phone!!,otp!!,textConfirmPassword!!)
                   if (response.success==1){
                       nextClickedEvent.call()
                   }
               }catch (e: NoInternetException){
                   authListenerInfo?.onWarning(e.message!!)
               }catch (e: HttpException){
                   authListenerInfo?.onWarning(e.message())
               }catch (e: ConnectException){
                   authListenerInfo?.onInfo(e.message!!)
               }
           }

        }
    }
}