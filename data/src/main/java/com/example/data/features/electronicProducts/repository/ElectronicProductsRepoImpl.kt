package com.example.data.features.electronicProducts.repository

import com.example.data.features.electronicProducts.dataSourceContract.ElectronicProductsDataSource
import com.example.domain.features.electronicsProduct.model.ElectronicProducts
import com.example.domain.features.electronicsProduct.repository.ElectronicsRepository
import javax.inject.Inject

class ElectronicProductsRepoImpl @Inject
constructor(private val dataSource: ElectronicProductsDataSource) : ElectronicsRepository {
    override suspend fun getElectronicProductsFromRemote(): List<ElectronicProducts?>? =
        dataSource.getElectronicProducts()
}