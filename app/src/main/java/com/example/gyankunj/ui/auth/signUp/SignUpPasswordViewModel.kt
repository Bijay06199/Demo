package com.example.gyankunj.ui.auth.signUp

import androidx.lifecycle.viewModelScope
import com.example.gyankunj.base.BaseViewModel
import com.example.gyankunj.data.repositories.SignUpRepository
import com.example.gyankunj.ui.auth.AuthListenerInfo
import com.example.gyankunj.utils.NoInternetException
import com.example.gyankunj.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.ConnectException

class SignUpPasswordViewModel(var signUpRepository: SignUpRepository) : BaseViewModel() {

    var textNewPassword: String? = null
    var authListenerInfo: AuthListenerInfo? = null
    var textConfirmPassword: String? = null
    var nextClickedEvent = SingleLiveEvent<Unit>()

    var phone = signUpRepository.preferenceManager.getNumber()
    var otp = signUpRepository.preferenceManager.getOTP()

    fun next() {
        if (textNewPassword.isNullOrEmpty()) {
            authListenerInfo?.onInfo("Enter new password")
        } else if (textConfirmPassword.isNullOrEmpty()) {
            authListenerInfo?.onInfo("Enter password to confirm")
        } else if (textConfirmPassword != textNewPassword) {
            authListenerInfo?.onWarning("Password doesnt match")
        } else {
            viewModelScope.launch {

                authListenerInfo?.onStarted()
                try {
                    var response =
                        signUpRepository.userSignUp(phone!!, otp!!, textConfirmPassword!!)
                    if (response.success == 1) {
                        nextClickedEvent.call()
                    }
                } catch (e: NoInternetException) {
                    authListenerInfo?.onWarning(e.message!!)
                } catch (e: HttpException) {
                    authListenerInfo?.onWarning(e.message())
                }catch (e: ConnectException){
                    authListenerInfo?.onInfo(e.message!!)
                }

            }

        }
    }

}