package com.akshay.quarguard.di.module

import android.app.Application
import android.content.Context
import com.akshay.quarguard.QuarguardApplication
import com.akshay.quarguard.di.ApplicationContext
import dagger.Module
import dagger.Provides
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
}