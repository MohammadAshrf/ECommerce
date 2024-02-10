package com.example.data.features.product.dataSourceContract

import com.example.domain.features.product.model.Product

interface ProductDataSource {
    suspend fun getProducts(): List<Product?>?
}