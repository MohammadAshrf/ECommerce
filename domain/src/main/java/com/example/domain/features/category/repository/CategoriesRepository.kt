package com.example.domain.features.category.repository

import com.example.domain.features.category.model.Category

interface CategoriesRepository {
    suspend fun getCategoriesFromRemote(page: Int = 1): List<Category?>?
}