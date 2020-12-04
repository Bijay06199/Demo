package com.example.gyankunj.ui.auth.signUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.andrognito.flashbar.Flashbar
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivitySignUpBinding
import com.example.gyankunj.ui.auth.AuthListenerInfo
import com.example.gyankunj.ui.auth.signIn.SignInActivity
import com.example.gyankunj.utils.extentions.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity : BaseActivity<ActivitySignUpBinding, SignUpViewModel>(), AuthListenerInfo {
    override fun getLayoutId(): Int = R.layout.activity_sign_up
    override fun getViewModel(): SignUpViewModel = signUpViewModel
    private val signUpViewModel: SignUpViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    private var flashbar: Flashbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setUpObservers()

    }

    private fun setUpObservers() {
        with(viewDataBinding) {
            with(signUpViewModel) {
                signUpViewModel.authListenerInfo = this@SignUpActivity
                backClickedEvent.observe(this@SignUpActivity, Observer {
                    startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
                })
            }
        }
    }

    private fun initView() {
        with(viewDataBinding) {

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