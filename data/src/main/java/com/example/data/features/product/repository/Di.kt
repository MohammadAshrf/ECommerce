package com.example.data.features.product.repository

import com.example.domain.features.product.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class Di {
    @Binds
    abstract fun bindProductRepository(
        productRepoImpl: ProductRepoImpl
    ): ProductRepository
}