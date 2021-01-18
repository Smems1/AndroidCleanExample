package com.smems.androidcleanexample.di.modules.features

import com.smems.androidcleanexample.di.FeatureScope
import com.smems.domain.repository.DetailsRepository
import com.smems.domain.usecase.GetDetailsUseCase
import dagger.Module
import dagger.Provides

@Module
class DetailsModule {

    @FeatureScope
    @Provides
    fun provideGetDetailsUseCase(detailsRepository: DetailsRepository) = GetDetailsUseCase(detailsRepository)
}