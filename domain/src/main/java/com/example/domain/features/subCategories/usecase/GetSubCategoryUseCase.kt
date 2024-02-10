package com.example.domain.features.subCategories.usecase

import com.example.domain.features.subCategories.repository.SubCategoryRepository
import javax.inject.Inject

class GetSubCategoryUseCase @Inject
constructor(private val subCategoryRepository: SubCategoryRepository) {
    suspend operator fun invoke(categoryId: String) =
        subCategoryRepository.getSubCategoryFromRemote(categoryId)
}