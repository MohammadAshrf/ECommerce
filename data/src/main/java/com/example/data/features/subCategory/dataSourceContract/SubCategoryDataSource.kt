package com.example.data.features.subCategory.dataSourceContract

import com.example.domain.features.subCategories.model.SubCategory

interface SubCategoryDataSource {
    suspend fun getSubCategory(categoryId: String): List<SubCategory?>?
}