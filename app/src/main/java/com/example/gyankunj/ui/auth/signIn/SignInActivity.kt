package com.example.gyankunj.ui.auth.signIn

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.andrognito.flashbar.Flashbar
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.data.repositories.FacebookLoginRepository
import com.example.gyankunj.databinding.ActivitySignInBinding
import com.example.gyankunj.ui.auth.AuthListenerInfo
import com.example.gyankunj.ui.home.MainActivity
import com.example.gyankunj.utils.extentions.*
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*


class SignInActivity : BaseActivity<ActivitySignInBinding, SignInViewModel>(), AuthListenerInfo {
    override fun getLayoutId(): Int = R.layout.activity_sign_in
    override fun getViewModel(): SignInViewModel = signInViewModel
    private val signInViewModel: SignInViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    var flashbar: Flashbar? = null

    private var callbackManager: CallbackManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        if (savedInstanceState == null) {
            if (preferenceManager.getLogged()) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }


    }

    private fun initView() {
        with(viewDataBinding) {
            with(signInViewModel) {
                signInViewModel.authListenerInfo = this@SignInActivity
                btnFacebookClickedEvent.observe(this@SignInActivity, Observer {
                    callbackManager = CallbackManager.Factory.create()
                    LoginManager.getInstance().logInWithReadPermissions(
                        this@SignInActivity,
                        Arrays.asList("public_profile", "email")
                    )

                    LoginManager.getInstance().registerCallback(callbackManager,
                        object : FacebookCallback<LoginResult> {
                            override fun onSuccess(result: LoginResult?) {
                                preferenceManager.setLogged(true)
                                var accessToken = result?.accessToken?.token
                                Log.d("fbtoken", result?.accessToken?.token)

                                viewModelScope.launch {
                                    facebookLoginRepository.facebookLogin(accessToken!!)

                                    startActivity(
                                        Intent(
                                            this@SignInActivity,
                                            MainActivity::class.java
                                        )
                                    )
                                }


                            }

                            override fun onCancel() {

                            }

                            override fun onError(error: FacebookException?) {
                                authListenerInfo?.onDanger(error!!.localizedMessage)
                            }

                        })

                })
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        callbackManager?.onActivityResult(requestCode, resultCode, data)


    }

    override fun onSuccess(message: String) {
        flashbar = successFlashBar(message)
        flashbar?.show()
        viewDataBinding.progressBar.hide()
        viewDataBinding.tvSignIn.showText()
    }

    override fun onStarted() {
        viewDataBinding.progressBar.show()
        viewDataBinding.tvSignIn.hideText()
    }

    override fun onInfo(message: String) {
        flashbar = infoFlashBar(message)
        flashbar?.show()
        viewDataBinding.progressBar.hide()
        viewDataBinding.tvSignIn.showText()
    }

    override fun onWarning(message: String) {
        flashbar = warningFlashBar(message)
        flashbar?.show()
        viewDataBinding.progressBar.hide()
        viewDataBinding.tvSignIn.showText()
    }

    override fun onDanger(message: String) {
        flashbar = dangerFlashBar(message)
        flashbar?.show()
        viewDataBinding.progressBar.hide()
        viewDataBinding.tvSignIn.showText()
    }
}