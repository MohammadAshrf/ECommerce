package com.example.domain.repositories.categories

import com.example.domain.entity.category.CategoryResponse

interface CategoriesRepository {
    suspend fun getCategoriesFromRemote(): CategoryResponse
}