package com.smems.androidcleanexample.di.components.features

import com.smems.androidcleanexample.MainViewModel
import com.smems.androidcleanexample.di.FeatureScope
import com.smems.androidcleanexample.di.modules.features.DetailsModule
import dagger.Subcomponent

@FeatureScope
@Subcomponent(modules = [DetailsModule::class])
interface DetailsComponent {
    fun inject(vm: MainViewModel)
}