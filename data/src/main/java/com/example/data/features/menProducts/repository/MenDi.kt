package com.example.data.features.womanProduct.repository

import com.example.data.features.menProducts.repository.MenProductsRepoImpl
import com.example.domain.features.mensProduct.repository.MensRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MenDi {
    @Binds
    abstract fun bindMenProductsRepository(
        menProductsRepoImpl: MenProductsRepoImpl
    ): MensRepository
}