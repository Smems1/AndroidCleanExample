package com.smems.androidcleanexample.di.modules

import android.content.Context
import androidx.room.Room
import com.smems.data.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "CleanExampleApp.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDetailsDao(appDatabase: AppDatabase) = appDatabase.detailsDao
}