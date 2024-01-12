package com.example.domain.features.electronicsProduct.repository

import com.example.domain.features.electronicsProduct.model.ElectronicProducts

interface ElectronicsRepository {
    suspend fun getElectronicProductsFromRemote(): List<ElectronicProducts?>?

}