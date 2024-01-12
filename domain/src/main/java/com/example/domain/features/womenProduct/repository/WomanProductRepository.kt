package com.example.domain.features.womenProduct.repository

import com.example.domain.features.womenProduct.model.WomanProduct

interface WomanProductRepository {
    suspend fun getProductsFromRemote(): List<WomanProduct?>?

}