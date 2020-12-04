package com.example.gyankunj.ui.auth.signUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andrognito.flashbar.Flashbar
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivitySignUpVerificationBinding
import com.example.gyankunj.ui.auth.AuthListenerInfo
import com.example.gyankunj.utils.extentions.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpVerificationActivity :
    BaseActivity<ActivitySignUpVerificationBinding, SignUpVerificationViewModel>(),
    AuthListenerInfo {
    override fun getLayoutId(): Int = R.layout.activity_sign_up_verification
    override fun getViewModel(): SignUpVerificationViewModel = signUpVerificationViewModel
    private val signUpVerificationViewModel: SignUpVerificationViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    var flashbar: Flashbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        code1()
        code2()
        code3()
    }

    private fun initView() {
        with(viewDataBinding) {
            signUpVerificationViewModel.authListenerInfo = this@SignUpVerificationActivity
            clBack.setOnClickListener {
                startActivity(Intent(this@SignUpVerificationActivity, SignUpActivity::class.java))
            }
            var number = preferenceManager.getNumber()
            tvNumber.setText(number)
        }
    }

    private fun code3() {
        with(viewDataBinding) {
            editTextWatcher(edtCode3, edtCode4)
        }
    }

    private fun code2() {
        with(viewDataBinding) {
            editTextWatcher(edtCode2, edtCode3)
        }
    }

    private fun code1() {
        with(viewDataBinding) {
            editTextWatcher(edtCode1, edtCode2)
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