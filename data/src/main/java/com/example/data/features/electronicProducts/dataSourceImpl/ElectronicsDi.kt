package com.example.data.features.electronicProducts.dataSourceImpl

import com.example.data.features.electronicProducts.dataSourceContract.ElectronicProductsDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ElectronicsDi {
    @Binds
    abstract fun bindElectronicProductsDataSource(
        electronicProductsDataSourceImpl: ElectronicProductsDataSourceImpl
    ): ElectronicProductsDataSource
}