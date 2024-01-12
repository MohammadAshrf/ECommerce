package com.example.data.features.category.dataSourceImpl

import com.example.data.api.WebServices
import com.example.data.features.category.dataSourceContract.CategoryDataSource
import com.example.domain.features.category.model.Category
import javax.inject.Inject

class CategoryDataSourceImpl @Inject constructor
    (private val webServices: WebServices) : CategoryDataSource {
    override suspend fun getCategories(page: Int): List<Category?>? {
        val response = webServices.getCategories()
        return response.data?.map {
            it?.toCategory()
        }
    }
}