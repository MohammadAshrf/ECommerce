package com.example.domain.features.subCategories.repository

import com.example.domain.features.subCategories.model.SubCategory

interface SubCategoryRepository {
    suspend fun getSubCategoryFromRemote(categoryId: String): List<SubCategory?>?
}