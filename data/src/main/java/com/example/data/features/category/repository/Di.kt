package com.example.data.features.category.repository

import com.example.domain.features.category.repository.CategoriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class Di {
    @Binds
    abstract fun bindCategoriesRepo(repo: CategoriesRepoImpl): CategoriesRepository
}