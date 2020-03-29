package com.akshay.quarguard.di

import javax.inject.Qualifier

/**
 * Created by akshaynandwana on
 * 29, March, 2020
 **/

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApplicationContext

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class ActivityContext

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class TempDirectory