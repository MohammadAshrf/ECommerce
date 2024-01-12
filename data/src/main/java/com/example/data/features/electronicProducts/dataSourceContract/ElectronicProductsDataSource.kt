package com.example.data.features.electronicProducts.dataSourceContract

import com.example.domain.features.electronicsProduct.model.ElectronicProducts

interface ElectronicProductsDataSource {
    suspend fun getElectronicProducts(): List<ElectronicProducts?>?
}