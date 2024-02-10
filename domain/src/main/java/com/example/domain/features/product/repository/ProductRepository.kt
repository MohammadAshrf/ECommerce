package com.example.domain.features.product.repository

import com.example.domain.features.product.model.Product

interface ProductRepository {
    suspend fun getProductsFromRemote(): List<Product?>?

}