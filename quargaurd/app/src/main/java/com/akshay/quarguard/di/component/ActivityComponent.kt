package com.akshay.quarguard.di.component

import com.akshay.quarguard.di.ActivityScope
import com.akshay.quarguard.di.module.ActivityModule
import com.akshay.quarguard.ui.login.LoginActivity
import com.akshay.quarguard.ui.signup.SignupActivity
import com.akshay.quarguard.ui.splash.SplashActivity
import dagger.Component

/**
 * Created by akshaynandwana on
 * 29, March, 2020
 **/

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(splashActivity: SplashActivity)

    fun inject(signupActivity: SignupActivity)

    fun inject(loginActivity: LoginActivity)
}