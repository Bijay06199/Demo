package com.example.gyankunj.ui.auth.signUp

import android.content.Intent
import android.view.View
import androidx.lifecycle.viewModelScope
import com.example.gyankunj.base.BaseViewModel
import com.example.gyankunj.data.prefs.PreferenceManager
import com.example.gyankunj.data.repositories.ForgotPasswordOTPRepository
import com.example.gyankunj.data.repositories.SignUpOTPRepository
import com.example.gyankunj.ui.auth.AuthListenerInfo
import com.example.gyankunj.ui.auth.forgotPassword.VerificationActivity
import com.example.gyankunj.utils.ApiException
import com.example.gyankunj.utils.NoInternetException
import com.example.gyankunj.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.NullPointerException
import java.net.ConnectException

class SignUpViewModel(private val signUpOTPRepository: SignUpOTPRepository) : BaseViewModel() {
    var txtPhoneNumber: String? = null
    var authListenerInfo: AuthListenerInfo? = null
    var backClickedEvent = SingleLiveEvent<Unit>()

    fun next(view: View) {
        if (txtPhoneNumber.isNullOrEmpty()) {
            authListenerInfo?.onInfo("Please enter number")
        } else {
            signUpOTPRepository.preferenceManager.setNumber(txtPhoneNumber)
            authListenerInfo?.onStarted()
            viewModelScope.launch {

                try {

                    val response = signUpOTPRepository.sendCode(txtPhoneNumber!!)
                    if (response.success == 1) {
                        Intent(view.context, SignUpVerificationActivity::class.java).also {
                            view.context.startActivity(it)
                            authListenerInfo?.onSuccess("Successfully sent code")
                        }
                    }


                } catch (e: ApiException) {

                } catch (e: NoInternetException) {
                    authListenerInfo?.onInfo(e.message!!)

                } catch (e: NullPointerException) {

                } catch (e: HttpException) {
                    authListenerInfo?.onWarning("Please enter valid number or make sure this number isnot registered")
                }catch (e: ConnectException){
                    authListenerInfo?.onInfo(e.message!!)
                }
            }


        }

    }

    fun back() {
        backClickedEvent.call()
    }

}