package com.example.gyankunj.ui.auth.forgotPassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import com.andrognito.flashbar.Flashbar
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivityForgotPasswordFinalBinding
import com.example.gyankunj.ui.auth.AuthListenerInfo
import com.example.gyankunj.ui.auth.signIn.SignInActivity
import com.example.gyankunj.utils.extentions.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForgotPasswordFinalActivity :
    BaseActivity<ActivityForgotPasswordFinalBinding, ForgotPasswordFinalViewModel>(),
    AuthListenerInfo {
    override fun getLayoutId(): Int = R.layout.activity_forgot_password_final
    override fun getViewModel(): ForgotPasswordFinalViewModel = forgotPasswordViewModel
    private val forgotPasswordViewModel: ForgotPasswordFinalViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    var flashbar: Flashbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {
        with(viewDataBinding) {
            with(forgotPasswordViewModel) {
                nextClickedEvent.observe(this@ForgotPasswordFinalActivity, Observer {
                    popUpWindow1(rootLayout, rootLayout, R.layout.password_changed_popup)
                    Handler().postDelayed({
                        popupWindow?.dismiss()
                        startActivity(
                            Intent(
                                this@ForgotPasswordFinalActivity,
                                SignInActivity::class.java
                            )
                        )
                    }, 2000)
                    popupWindow?.setOnDismissListener {
                        startActivity(
                            Intent(
                                this@ForgotPasswordFinalActivity,
                                SignInActivity::class.java
                            )
                        )
                    }
                })

            }
        }
    }

    private fun initView() {
        with(viewDataBinding) {
            forgotPasswordViewModel.authListenerInfo = this@ForgotPasswordFinalActivity
            clBack.setOnClickListener {
                startActivity(
                    Intent(
                        this@ForgotPasswordFinalActivity,
                        VerificationActivity::class.java
                    )
                )
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