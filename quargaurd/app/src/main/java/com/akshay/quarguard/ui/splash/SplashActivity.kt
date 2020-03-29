package com.akshay.quarguard.ui.splash

import android.os.Bundle
import androidx.lifecycle.Observer
import com.akshay.quarguard.R
import com.akshay.quarguard.di.component.ActivityComponent
import com.akshay.quarguard.ui.base.BaseActivity
import com.akshay.quarguard.utils.common.Event

class SplashActivity : BaseActivity<SplashViewModel>() {

    companion object {
        const val TAG = "SplashActivity"
    }

    override fun provideLayoutId(): Int = R.layout.activity_splash

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
    }

    override fun setupObservers() {
        super.setupObservers()
        // Event is used by the view model to tell the activity to launch another activity
        // view model also provided the Bundle in the event that is needed for the Activity
        viewModel.launchRegister.observe(this, Observer<Event<Map<String, String>>> {
            it.getIfNotHandled()?.run {
                // startActivity(Intent(applicationContext, SignupActivity::class.java))
            }
        })

        viewModel.launchMain.observe(this, Observer<Event<Map<String, String>>> {
            it.getIfNotHandled()?.run {
                // startActivity(Intent(applicationContext, MainActivity::class.java))
            }
        })
    }
}