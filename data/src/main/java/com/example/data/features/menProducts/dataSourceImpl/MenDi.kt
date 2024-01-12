package com.example.data.features.menProducts.dataSourceImpl

import com.example.data.features.menProducts.dataSourceContract.MenProductsDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MenDi {
    @Binds
    abstract fun bindMenProductsDataSource(
        menProductsDataSourceImpl: MenProductsDataSourceImpl
    ): MenProductsDataSource
}