package com.example.data.api

import com.example.data.model.category.CategoriesResponse
import com.example.data.model.product.ProductResponse
import com.example.data.model.subCategory.SubCategoryResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebServices {
    @GET("api/v1/categories")
    suspend fun getCategories(@Query("page") page: Int = 1): CategoriesResponse

    @GET("api/v1/products")
    suspend fun getWomanProducts(@Query("category[in]") categoryId: String? = null): ProductResponse

    @GET("/api/v1/categories/{category_id}/subcategories")
    suspend fun getSubCategoriesOnCategory(
        @Path("category_id") categoryId: String
    ): SubCategoryResponse

}