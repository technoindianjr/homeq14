package com.akshay.quarguard.di.component

import android.app.Application
import android.content.Context
import com.akshay.quarguard.QuarguardApplication
import com.akshay.quarguard.di.ApplicationContext
import com.akshay.quarguard.di.module.ApplicationModule
import dagger.Component
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
}