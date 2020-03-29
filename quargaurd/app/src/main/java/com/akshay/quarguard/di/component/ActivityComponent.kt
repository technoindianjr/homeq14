package com.akshay.quarguard.di.component

import com.akshay.quarguard.di.ActivityScope
import com.akshay.quarguard.di.module.ActivityModule
import dagger.Component

/**
 * Created by akshaynandwana on
 * 29, March, 2020
 **/

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {


}