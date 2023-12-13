package com.example.domain.repositories.appliance

import com.example.domain.entity.category.CategoryResponse
import com.example.domain.entity.subcategory.SubCategoryResponse

interface ApplianceRepository {
    suspend fun getApplianceFromRemote(): CategoryResponse
}