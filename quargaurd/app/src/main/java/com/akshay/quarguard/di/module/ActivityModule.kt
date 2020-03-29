package com.akshay.quarguard.di.module

import androidx.lifecycle.ViewModelProviders
import com.akshay.quarguard.ui.base.BaseActivity
import com.akshay.quarguard.ui.login.LoginViewModel
import com.akshay.quarguard.ui.main.MainViewModel
import com.akshay.quarguard.ui.signup.SignupViewModel
import com.akshay.quarguard.ui.splash.SplashViewModel
import com.akshay.quarguard.utils.ViewModelProviderFactory
import com.akshay.quarguard.utils.network.NetworkHelper
import com.akshay.quarguard.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by akshaynandwana on
 * 29, March, 2020
 **/

/**
 * Kotlin Generics Reference: https://kotlinlang.org/docs/reference/generics.html
 * Basically it means that we can pass any class that extends BaseActivity which take
 * BaseViewModel subclass as parameter
 */
@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideSplashViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): SplashViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(SplashViewModel::class) {
            SplashViewModel(schedulerProvider, compositeDisposable, networkHelper)
            //this lambda creates and return SplashViewModel
        }).get(SplashViewModel::class.java)

    @Provides
    fun provideMainViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): MainViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(schedulerProvider, compositeDisposable, networkHelper)
            //this lambda creates and return MainViewModel
        }).get(MainViewModel::class.java)

    @Provides
    fun provideSignupViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): SignupViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(SignupViewModel::class) {
            SignupViewModel(schedulerProvider, compositeDisposable, networkHelper)
            //this lambda creates and return SignupViewModel
        }).get(SignupViewModel::class.java)

    @Provides
    fun provideLoginViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): LoginViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(LoginViewModel::class) {
            LoginViewModel(schedulerProvider, compositeDisposable, networkHelper)
            //this lambda creates and return LoginViewModel
        }).get(LoginViewModel::class.java)
}