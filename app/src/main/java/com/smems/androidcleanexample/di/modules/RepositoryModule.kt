package com.smems.androidcleanexample.di.modules

import android.content.Context
import com.smems.data.dao.DetailsDao
import com.smems.data.repository.DetailsDataRepository
import com.smems.domain.repository.DetailsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideDetailsRepository(context: Context, detailsDao: DetailsDao): DetailsRepository =
        DetailsDataRepository(context, detailsDao)
}