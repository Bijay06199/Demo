package com.example.gyankunj.ui.auth.signUp

import android.content.Intent
import android.view.View
import androidx.lifecycle.viewModelScope
import com.example.gyankunj.base.BaseViewModel
import com.example.gyankunj.data.repositories.ForgotPasswordOTPRepository
import com.example.gyankunj.data.repositories.SignUpOTPRepository
import com.example.gyankunj.data.repositories.SignUpOTPVerificationRepository
import com.example.gyankunj.ui.auth.AuthListenerInfo
import com.example.gyankunj.utils.ApiException
import com.example.gyankunj.utils.NoInternetException
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.NullPointerException
import java.net.ConnectException

class SignUpVerificationViewModel(
    var signUpOtpVerificationRepository: SignUpOTPVerificationRepository,
    private val signUpOTPRepository: SignUpOTPRepository
) : BaseViewModel() {
    var otp1: String? = null
    var otp2: String? = null
    var otp3: String? = null
    var otp4: String? = null
    var authListenerInfo: AuthListenerInfo? = null


    var phone = signUpOtpVerificationRepository.preferenceManager.getNumber()


    fun next(view: View) {
        var otp = otp1 + otp2 + otp3 + otp4
        signUpOtpVerificationRepository.preferenceManager.setOTP(otp)
        viewModelScope.launch {
            authListenerInfo?.onStarted()
            try {
                var response = signUpOtpVerificationRepository.verifyOTPCode(phone!!, otp)
                if (response.success == 1) {
                    Intent(view.context, SignUpPasswordActivity::class.java).also {
                        view.context.startActivity(it)
                        authListenerInfo?.onSuccess("Verified OTP Code")
                    }
                }

            } catch (e: NoInternetException) {
                authListenerInfo?.onWarning(e.message!!)
            } catch (e: HttpException) {
                authListenerInfo?.onDanger("Invalid otp code")
            }catch (e: ConnectException){
                authListenerInfo?.onInfo(e.message!!)
            }
        }


    }

    fun resend() {
        var txtPhoneNumber = signUpOTPRepository.preferenceManager.getNumber()
        viewModelScope.launch {

            try {

                signUpOTPRepository.sendCode(txtPhoneNumber!!)


            } catch (e: ApiException) {

            } catch (e: NoInternetException) {
                authListenerInfo?.onInfo(e.message!!)

            } catch (e: NullPointerException) {

            } catch (e: HttpException) {
                authListenerInfo?.onWarning("Please enter valid number or make sure this number isnot registered")
            }
        }
    }
}