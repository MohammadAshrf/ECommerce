package com.example.data.repository

import com.example.data.dataSource.ApiService
import com.example.domain.entity.category.CategoryResponse
import com.example.domain.entity.subcategory.SubCategoryResponse
import com.example.domain.repositories.appliance.ApplianceRepository

class ApplianceRepoImpl(private val apiService: ApiService) : ApplianceRepository {
    override suspend fun getApplianceFromRemote(): CategoryResponse = apiService.getAppliance()

}