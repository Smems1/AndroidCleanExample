package com.smems.androidcleanexample.base

import android.app.Application
import com.smems.androidcleanexample.di.components.ApplicationComponent
import com.smems.androidcleanexample.di.components.DaggerApplicationComponent
import com.smems.androidcleanexample.di.modules.ApplicationModule

class App : Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}