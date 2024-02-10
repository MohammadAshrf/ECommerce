package com.example.data.features.subCategory.dataSourceImpl

import com.example.data.api.WebServices
import com.example.data.features.subCategory.dataSourceContract.SubCategoryDataSource
import com.example.domain.features.subCategories.model.SubCategory
import javax.inject.Inject

class SubCategoryDataSourceImpl @Inject constructor(
    private val webServices: WebServices
) : SubCategoryDataSource {
    override suspend fun getSubCategory(categoryId: String): List<SubCategory?>? {
        val response = webServices.getSubCategoriesOnCategory(categoryId)
        return response.data?.map {
            it?.toSubCategory()
        }
    }
}