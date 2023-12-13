package com.example.data.dataSource

import com.example.data.model.CategoriesResponseModel
import com.example.domain.entity.category.CategoryResponse
import com.example.domain.entity.subcategory.SubCategoryResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/categories")
    suspend fun getCategories(): CategoriesResponseModel

    @GET("api/v1/subcategories/6439d3e067d9aa4ca97064c3/subcategories")
    suspend fun getAppliance(): CategoryResponse
}