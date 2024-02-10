package com.example.data.features.subCategory.dataSourceImpl

import com.example.data.features.subCategory.dataSourceContract.SubCategoryDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class Di {
    @Binds
    abstract fun bindSubCategoryDataSource(
        subCategoryDataSourceImpl: SubCategoryDataSourceImpl
    ): SubCategoryDataSource
}