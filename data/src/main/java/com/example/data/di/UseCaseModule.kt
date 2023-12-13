package com.example.data.di

import com.example.domain.repositories.appliance.ApplianceRepository
import com.example.domain.repositories.categories.CategoriesRepository
import com.example.domain.usecase.GetAppliance
import com.example.domain.usecase.GetCategories
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

object UseCaseModule {
    @Provides
    fun provideCategoriesUseCase(categoriesRepository: CategoriesRepository): GetCategories {
        return GetCategories(categoriesRepository)
    }

    @Provides
    fun provideApplianceUseCase(applianceRepository: ApplianceRepository): GetAppliance {
        return GetAppliance(applianceRepository)
    }
}