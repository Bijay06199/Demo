package com.example.gyankunj.ui.auth.signUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import com.andrognito.flashbar.Flashbar
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivitySignUpPasswordBinding
import com.example.gyankunj.ui.auth.AuthListenerInfo
import com.example.gyankunj.ui.auth.signIn.SignInActivity
import com.example.gyankunj.utils.extentions.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpPasswordActivity :
    BaseActivity<ActivitySignUpPasswordBinding, SignUpPasswordViewModel>(), AuthListenerInfo {
    override fun getLayoutId(): Int = R.layout.activity_sign_up_password
    override fun getViewModel(): SignUpPasswordViewModel = signUpViewModel
    private val signUpViewModel: SignUpPasswordViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    var flashbar: Flashbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpObservers()

    }

    private fun setUpObservers() {
        with(viewDataBinding) {
            with(signUpViewModel) {
                signUpViewModel.authListenerInfo = this@SignUpPasswordActivity
                clBack.setOnClickListener {
                    startActivity(
                        Intent(
                            this@SignUpPasswordActivity,
                            SignUpVerificationActivity::class.java
                        )
                    )
                }
                nextClickedEvent.observe(this@SignUpPasswordActivity, Observer {
                    popUpWindow1(rootLayout, rootLayout, R.layout.signup_successful_popup)
                    Handler().postDelayed({
                        popupWindow?.dismiss()
                        startActivity(
                            Intent(
                                this@SignUpPasswordActivity,
                                SignInActivity::class.java
                            )
                        )
                    }, 2000)
                    popupWindow?.setOnDismissListener {
                        startActivity(
                            Intent(
                                this@SignUpPasswordActivity,
                                SignInActivity::class.java
                            )
                        )
                    }
                })

            }
        }
    }

    override fun onSuccess(message: String) {
        flashbar = successFlashBar(message)
        flashbar?.show()
        viewDataBinding.progressBar.hide()
        viewDataBinding.tvNext.showText()
    }

    override fun onStarted() {
        viewDataBinding.progressBar.show()
        viewDataBinding.tvNext.hideText()
    }

    override fun onInfo(message: String) {
        flashbar = infoFlashBar(message)
        flashbar?.show()
        viewDataBinding.progressBar.hide()
        viewDataBinding.tvNext.showText()
    }

    override fun onWarning(message: String) {
        flashbar = warningFlashBar(message)
        flashbar?.show()
        viewDataBinding.progressBar.hide()
        viewDataBinding.tvNext.showText()
    }

    override fun onDanger(message: String) {
        flashbar = dangerFlashBar(message)
        flashbar?.show()
        viewDataBinding.progressBar.hide()
        viewDataBinding.tvNext.showText()
    }
}