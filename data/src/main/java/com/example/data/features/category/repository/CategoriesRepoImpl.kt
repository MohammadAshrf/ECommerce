package com.example.data.features.category.repository

import com.example.data.features.category.dataSourceContract.CategoryDataSource
import com.example.domain.features.category.model.Category
import com.example.domain.features.category.repository.CategoriesRepository
import javax.inject.Inject

class CategoriesRepoImpl @Inject constructor
    (private val dataSource: CategoryDataSource) : CategoriesRepository {
    override suspend fun getCategoriesFromRemote(page: Int): List<Category?>? =
        dataSource.getCategories()

}