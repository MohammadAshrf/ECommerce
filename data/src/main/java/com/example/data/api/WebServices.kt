package com.example.data.api

import com.example.data.model.category.CategoriesResponse
import com.example.data.model.product.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {
    @GET("api/v1/categories")
    suspend fun getCategories(@Query("page") page: Int = 1): CategoriesResponse

    @GET("api/v1/products")
    suspend fun getWomanProducts(@Query("category[in]") categoryId: String? = null): ProductResponse

    @GET("api/v1/products")
    suspend fun getMenProducts(@Query("category[in]") categoryId: String? = null): ProductResponse

    @GET("api/v1/products")
    suspend fun getElectronicProducts(@Query("category[in]") categoryId: String? = null): ProductResponse
}