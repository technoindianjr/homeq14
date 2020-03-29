package com.akshay.quarguard.ui.signup

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import com.akshay.quarguard.R
import com.akshay.quarguard.di.component.ActivityComponent
import com.akshay.quarguard.ui.base.BaseActivity
import com.akshay.quarguard.ui.login.LoginActivity
import com.akshay.quarguard.ui.main.MainActivity
import com.akshay.quarguard.utils.common.Event
import com.akshay.quarguard.utils.common.Status
import kotlinx.android.synthetic.main.activity_signup.*

/**
 * Created by akshaynandwana on
 * 14, November, 2019
 **/

class SignupActivity : BaseActivity<SignupViewModel>() {

    companion object {
        const val TAG = "SignupActivity"
    }

    override fun provideLayoutId(): Int = R.layout.activity_signup

    override fun injectDependencies(activityComponent: ActivityComponent) =
        activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {

        et_email.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.onEmailChange(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        })

        et_password.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.onPasswordChange(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        })

        et_name.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.onNameChange(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        })

        btn_signup.setOnClickListener { viewModel.onSignUp() }

        tv_register.setOnClickListener { viewModel.launchLogin() }

        iv_clear.setOnClickListener { viewModel.clearEmailField() }
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.launchMain.observe(this, Observer<Event<Map<String, String>>> {
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            }
        })

        viewModel.launchLogin.observe(this, Observer<Event<Map<String, String>>> {
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, LoginActivity::class.java))
                finish()
            }
        })

        viewModel.nameField.observe(this, Observer {
            if (et_name.text.toString() != it) et_name.setText(it)
        })

        viewModel.emailField.observe(this, Observer {
            iv_clear.visibility = if (it.length == 0) View.INVISIBLE else View.VISIBLE
            if (et_email.text.toString() != it)
                et_email.setText(it)
        })

        viewModel.emailValidation.observe(this, Observer {
            when (it.status) {
                Status.ERROR -> layout_email.error = it.data?.run { getString(this) }
                else -> layout_email.isErrorEnabled = false
            }
        })

        viewModel.passwordField.observe(this, Observer {
            if (et_password.text.toString() != it) et_email.setText(it)
        })

        viewModel.passwordValidation.observe(this, Observer {
            when (it.status) {
                Status.ERROR -> layout_password.error = it.data?.run { getString(this) }
                else -> layout_password.isErrorEnabled = false
            }
        })

        viewModel.signingUp.observe(this, Observer {
            pb_loading.visibility = if (it) View.VISIBLE else View.GONE
        })
    }

}