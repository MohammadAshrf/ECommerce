package com.example.data.features.electronicProducts.repository

import com.example.domain.features.electronicsProduct.repository.ElectronicsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ElectronicsDi {
    @Binds
    abstract fun bindElectronicProductsRepository(
        electronicProductsRepoImpl: ElectronicProductsRepoImpl
    ): ElectronicsRepository
}