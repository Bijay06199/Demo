package com.example.gyankunj.ui.auth.forgotPassword

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import com.example.gyankunj.base.BaseViewModel
import com.example.gyankunj.data.prefs.PreferenceManager
import com.example.gyankunj.data.repositories.ForgotPasswordOTPRepository
import com.example.gyankunj.ui.auth.AuthListenerInfo
import com.example.gyankunj.utils.ApiException
import com.example.gyankunj.utils.NoInternetException
import com.example.gyankunj.utils.extentions.isValidNumber
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.NullPointerException
import java.net.ConnectException

class ForgotPasswordViewModel(var forgotPasswordOTPRepository: ForgotPasswordOTPRepository) :
    BaseViewModel() {
    var txtPhoneNumber: String? = null
    var authListenerInfo: AuthListenerInfo? = null

    fun next(view: View) {
        if (txtPhoneNumber.isNullOrEmpty()) {
            authListenerInfo?.onInfo("Please enter phone number")
        } else {
            forgotPasswordOTPRepository.preferenceManager.setNumber(txtPhoneNumber)
            authListenerInfo?.onStarted()
            viewModelScope.launch {

                try {

                    val response = forgotPasswordOTPRepository.sendCode(txtPhoneNumber!!)
                    if (response.success == 1) {
                        Intent(view.context, VerificationActivity::class.java).also {
                            view.context.startActivity(it)
                        }
                        authListenerInfo?.onSuccess("Successfully sent code")

                    } else if (response.message == "Phone number already exist.") {
                        authListenerInfo?.onInfo("Phone number already exist")
                    }


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
    }
}