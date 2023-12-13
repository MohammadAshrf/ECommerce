package com.example.data.repository

import com.example.data.dataSource.ApiService
import com.example.data.mappers.toEntity
import com.example.domain.entity.category.CategoryResponse
import com.example.domain.repositories.categories.CategoriesRepository

class CategoriesRepoImpl(private val apiService: ApiService) : CategoriesRepository {
    override suspend fun getCategoriesFromRemote(): CategoryResponse =
        apiService.getCategories().toEntity()

}