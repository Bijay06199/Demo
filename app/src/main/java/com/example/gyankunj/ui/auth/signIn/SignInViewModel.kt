package com.example.gyankunj.ui.auth.signIn

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewModelScope
import com.example.gyankunj.base.BaseViewModel
import com.example.gyankunj.data.repositories.FacebookLoginRepository
import com.example.gyankunj.data.repositories.SignInRepository
import com.example.gyankunj.ui.auth.AuthListenerInfo
import com.example.gyankunj.ui.auth.forgotPassword.ForgotPasswordActivity
import com.example.gyankunj.ui.auth.signUp.SignUpActivity
import com.example.gyankunj.ui.home.MainActivity
import com.example.gyankunj.utils.ApiException
import com.example.gyankunj.utils.NoInternetException
import com.example.gyankunj.utils.SingleLiveEvent
import com.example.gyankunj.utils.extentions.isValidNumber
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.IllegalStateException
import java.lang.NullPointerException
import java.net.ConnectException
import java.util.*

class SignInViewModel(private val signInRepository: SignInRepository, val facebookLoginRepository: FacebookLoginRepository) :BaseViewModel(){



    var activity:Activity?=null
    var authListenerInfo: AuthListenerInfo?=null
    var txtPhoneNumber:String?=null
    var txtPassword:String?=null
    var btnFacebookClickedEvent=SingleLiveEvent<Unit>()
    private var callbackManager: CallbackManager?=null




    fun facebook(view: View){

        btnFacebookClickedEvent.call()

    }

    fun forgotPassword(view: View){
        Intent(view.context,ForgotPasswordActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun signUp(view: View){
        Intent(view.context,SignUpActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun sigIn(view: View){

        if (txtPhoneNumber.isNullOrEmpty()){
            authListenerInfo?.onInfo("Please enter phone number")
        }
        else if (txtPassword.isNullOrEmpty()){
            authListenerInfo?.onInfo("Please enter password")
        }
        else if (txtPhoneNumber!!.isValidNumber(txtPhoneNumber)){

            viewModelScope.launch {

                try {
                    authListenerInfo?.onStarted()
                    val response=signInRepository.normalLogin(txtPhoneNumber!!,txtPassword!!)
                    if (response.message=="Success"){
                        authListenerInfo?.onSuccess("Login Successful")
                        Intent(view.context,MainActivity::class.java).also {
                            view.context.startActivity(it)
                        }
                    }


                }catch (e: ApiException){
                    authListenerInfo?.onDanger(e.message!!)
                }catch (e: NoInternetException){
                    authListenerInfo?.onInfo(e.message!!)
                }catch (e: NullPointerException){
                    authListenerInfo?.onDanger("Password too short")
                }catch (e:IllegalStateException){

                }catch (e:HttpException){
                    authListenerInfo?.onWarning("Invalid Credentials")
                }catch (e:ConnectException){
                    authListenerInfo?.onInfo(e.message!!)
                }
            }

        }
        else{
            authListenerInfo?.onWarning("Please enter valid number")

        }

    }
}