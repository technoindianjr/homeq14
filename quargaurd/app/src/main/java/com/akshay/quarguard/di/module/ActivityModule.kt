package com.akshay.quarguard.di.module

import com.akshay.quarguard.ui.base.BaseActivity
import dagger.Module

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

}