package com.akshay.quarguard.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.akshay.quarguard.BuildConfig
import com.akshay.quarguard.QuarguardApplication
import com.akshay.quarguard.data.remote.NetworkService
import com.akshay.quarguard.data.remote.Networking
import com.akshay.quarguard.di.ApplicationContext
import com.akshay.quarguard.di.TempDirectory
import com.akshay.quarguard.utils.common.FileUtils
import com.akshay.quarguard.utils.network.NetworkHelper
import com.akshay.quarguard.utils.rx.RxSchedulerProvider
import com.akshay.quarguard.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by akshaynandwana on
 * 29, March, 2020
 **/

@Module
class ApplicationModule(private val application: QuarguardApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    @Singleton
    @TempDirectory
    fun provideTempDirectory() = FileUtils.getDirectory(application, "temp")

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences =
        application.getSharedPreferences("quarguard-project-prefs", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
        Networking.create(
            BuildConfig.API_KEY,
            BuildConfig.BASE_URL,
            application.cacheDir,
            10 * 1024 * 1024 // 10MB
        )

    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)
}