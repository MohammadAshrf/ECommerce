package com.example.data.features.menProducts.repository

import com.example.data.features.menProducts.dataSourceContract.MenProductsDataSource
import com.example.domain.features.mensProduct.model.MensProduct
import com.example.domain.features.mensProduct.repository.MensRepository
import javax.inject.Inject

class MenProductsRepoImpl @Inject
constructor(private val dataSource: MenProductsDataSource) : MensRepository {
    override suspend fun getMenProductsFromRemote(): List<MensProduct?>? =
        dataSource.getMenProducts()
}