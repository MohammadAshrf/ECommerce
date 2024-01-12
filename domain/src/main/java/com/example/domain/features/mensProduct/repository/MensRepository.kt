package com.example.domain.features.mensProduct.repository

import com.example.domain.features.mensProduct.model.MensProduct

interface MensRepository {
    suspend fun getMenProductsFromRemote(): List<MensProduct?>?

}