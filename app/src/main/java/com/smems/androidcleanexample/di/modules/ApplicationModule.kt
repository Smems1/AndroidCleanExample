package com.smems.androidcleanexample.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val context: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context = context.applicationContext
}