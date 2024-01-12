package com.example.data.features.womanProduct.dataSourceContract

import com.example.domain.features.womenProduct.model.WomanProduct

interface ProductDataSource {
    suspend fun getProducts(): List<WomanProduct?>?
}