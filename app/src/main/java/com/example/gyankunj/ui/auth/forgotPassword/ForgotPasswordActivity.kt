package com.example.gyankunj.ui.auth.forgotPassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andrognito.flashbar.Flashbar
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivityForgotPasswordBinding
import com.example.gyankunj.ui.auth.AuthListenerInfo
import com.example.gyankunj.ui.auth.signIn.SignInActivity
import com.example.gyankunj.utils.extentions.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForgotPasswordActivity :
    BaseActivity<ActivityForgotPasswordBinding, ForgotPasswordViewModel>(), AuthListenerInfo {
    override fun getLayoutId(): Int = R.layout.activity_forgot_password
    override fun getViewModel(): ForgotPasswordViewModel = forgotPasswordViewModel
    private val forgotPasswordViewModel: ForgotPasswordViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    var flashbar: Flashbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        with(viewDataBinding) {
            forgotPasswordViewModel.authListenerInfo = this@ForgotPasswordActivity
            clBack.setOnClickListener {
                startActivity(Intent(this@ForgotPasswordActivity, SignInActivity::class.java))
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