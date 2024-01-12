package com.example.data.features.menProducts.dataSourceContract

import com.example.domain.features.mensProduct.model.MensProduct

interface MenProductsDataSource {
    suspend fun getMenProducts(): List<MensProduct?>?
}