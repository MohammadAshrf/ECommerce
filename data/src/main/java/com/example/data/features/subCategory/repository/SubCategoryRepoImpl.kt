package com.example.data.features.subCategory.repository

import com.example.data.features.subCategory.dataSourceContract.SubCategoryDataSource
import com.example.domain.features.subCategories.model.SubCategory
import com.example.domain.features.subCategories.repository.SubCategoryRepository
import javax.inject.Inject

class SubCategoryRepoImpl @Inject constructor(
    private val dataSource: SubCategoryDataSource
) : SubCategoryRepository {
    override suspend fun getSubCategoryFromRemote(categoryId: String): List<SubCategory?>? =
        dataSource.getSubCategory(categoryId)
}