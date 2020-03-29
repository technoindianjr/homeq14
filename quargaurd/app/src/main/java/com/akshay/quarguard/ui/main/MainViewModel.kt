package com.akshay.quarguard.ui.main

import com.akshay.quarguard.ui.base.BaseViewModel
import com.akshay.quarguard.utils.network.NetworkHelper
import com.akshay.quarguard.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by akshaynandwana on
 * 29, March, 2020
 **/
class MainViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    override fun onCreate() {

    }
}