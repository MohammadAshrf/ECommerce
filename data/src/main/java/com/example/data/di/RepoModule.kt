package com.example.data.di

import com.example.data.dataSource.ApiService
import com.example.data.repository.ApplianceRepoImpl
import com.example.data.repository.CategoriesRepoImpl
import com.example.domain.entity.subcategory.SubCategoryResponse
import com.example.domain.repositories.appliance.ApplianceRepository
import com.example.domain.repositories.categories.CategoriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideCategoriesRepo(apiService: ApiService): CategoriesRepository {
        return CategoriesRepoImpl(apiService)
    }

    @Provides
    fun provideApplianceRepo(apiService: ApiService): ApplianceRepository {
        return ApplianceRepoImpl(apiService)
    }


}