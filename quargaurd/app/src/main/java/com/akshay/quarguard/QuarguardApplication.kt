package com.akshay.quarguard

import android.app.Application
import com.akshay.quarguard.di.component.ApplicationComponent
import com.akshay.quarguard.di.component.DaggerApplicationComponent
import com.akshay.quarguard.di.module.ApplicationModule

/**
 * Created by akshaynandwana on
 * 29, March, 2020
 **/
class QuarguardApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}