package com.example.domain.features.category.usecase

import com.example.domain.features.category.model.Category
import com.example.domain.features.category.repository.CategoriesRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val categoriesRepository: CategoriesRepository) {
    suspend operator fun invoke(): List<Category?>? = categoriesRepository.getCategoriesFromRemote()
}