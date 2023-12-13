package com.example.domain.usecase

import com.example.domain.repositories.categories.CategoriesRepository

class GetCategories(private val categoriesRepository: CategoriesRepository) {
    suspend operator fun invoke() = categoriesRepository.getCategoriesFromRemote()
}