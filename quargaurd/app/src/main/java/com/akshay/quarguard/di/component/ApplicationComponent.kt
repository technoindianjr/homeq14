package com.akshay.quarguard.di.component

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.akshay.quarguard.QuarguardApplication
import com.akshay.quarguard.data.remote.NetworkService
import com.akshay.quarguard.di.ApplicationContext
import com.akshay.quarguard.di.TempDirectory
import com.akshay.quarguard.di.module.ApplicationModule
import com.akshay.quarguard.utils.network.NetworkHelper
import com.akshay.quarguard.utils.rx.SchedulerProvider
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import java.io.File
import javax.inject.Singleton

/**
 * Created by akshaynandwana on
 * 29, March, 2020
 **/

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: QuarguardApplication)

    fun getApplication(): Application

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getSharedPreferences(): SharedPreferences

    fun getNetworkHelper(): NetworkHelper

    fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable

    @TempDirectory
    fun getTempDirectory(): File
}