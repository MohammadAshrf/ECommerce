package com.example.data.features.subCategory.repository

import com.example.domain.features.subCategories.repository.SubCategoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class Di {
    @Binds
    abstract fun bindSubCategoryRepository(
        subCategoryRepoImpl: SubCategoryRepoImpl
    ): SubCategoryRepository
}