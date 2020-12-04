package com.example.gyankunj.ui.auth.forgotPassword

import android.content.Intent
import android.view.View
import androidx.lifecycle.viewModelScope
import com.example.gyankunj.base.BaseViewModel
import com.example.gyankunj.data.repositories.ForgotPasswordOTPRepository
import com.example.gyankunj.data.repositories.ForgotPasswordOTPVerificationRepository
import com.example.gyankunj.data.repositories.SignUpOTPVerificationRepository
import com.example.gyankunj.ui.auth.AuthListenerInfo
import com.example.gyankunj.utils.ApiException
import com.example.gyankunj.utils.NoInternetException
import com.example.gyankunj.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.NullPointerException
import java.net.ConnectException

class VerificationViewModel(
    private val forgotPasswordOTPVerificationRepository: ForgotPasswordOTPVerificationRepository,
    private val forgotPasswordOTPRepository: ForgotPasswordOTPRepository
) : BaseViewModel() {
    var otp1: String? = null
    var otp2: String? = null
    var otp3: String? = null
    var otp4: String? = null
    var authListenerInfo: AuthListenerInfo? = null



    var phone = forgotPasswordOTPVerificationRepository.preferenceManager.getNumber()


    fun resendCode(view: View) {
        viewModelScope.launch {

            try {

                forgotPasswordOTPRepository.sendCode(phone!!)


            } catch (e: ApiException) {

            } catch (e: NoInternetException) {
                authListenerInfo?.onInfo(e.message!!)

            } catch (e: NullPointerException) {

            } catch (e: HttpException) {
                authListenerInfo?.onWarning(e.message())
            }catch (e: ConnectException){
                authListenerInfo?.onInfo(e.message!!)
            }
        }
    }


    fun next(view: View) {
        var otp = otp1 + otp2 + otp3 + otp4

        forgotPasswordOTPVerificationRepository.preferenceManager.setOTP(otp)
        viewModelScope.launch {
            authListenerInfo?.onStarted()
            try {
                var response = forgotPasswordOTPVerificationRepository.verifyOTPCode(phone!!, otp)
                if (response.success == 1) {
                    Intent(view.context, ForgotPasswordFinalActivity::class.java).also {
                        view.context.startActivity(it)
                        authListenerInfo?.onSuccess("Verified OTP code")

                    }
                } else {
                    authListenerInfo?.onInfo("Enter the correct otp code")
                }
            } catch (e: NoInternetException) {
                authListenerInfo?.onWarning(e.message!!)
            } catch (e: HttpException) {
                authListenerInfo?.onDanger(e.message())
            }
        }


    }

}