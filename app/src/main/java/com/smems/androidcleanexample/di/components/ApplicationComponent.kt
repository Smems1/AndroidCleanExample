package com.smems.androidcleanexample.di.components

import com.smems.androidcleanexample.base.App
import com.smems.androidcleanexample.di.components.features.DetailsComponent
import com.smems.androidcleanexample.di.modules.ApplicationModule
import com.smems.androidcleanexample.di.modules.DatabaseModule
import com.smems.androidcleanexample.di.modules.RepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        DatabaseModule::class,
        RepositoryModule::class
    ]
)
interface ApplicationComponent {
    fun inject(app: App)

    fun detailsComponent(): DetailsComponent
}