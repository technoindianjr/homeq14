package com.akshay.quarguard.di

import javax.inject.Scope

/**
 * Created by akshaynandwana on
 * 29, March, 2020
 **/

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class FragmentScope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class ViewModelScope