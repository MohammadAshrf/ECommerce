package com.example.data.features.category.dataSourceContract

import com.example.domain.features.category.model.Category

interface CategoryDataSource {
    suspend fun getCategories(page: Int = 1): List<Category?>?
}