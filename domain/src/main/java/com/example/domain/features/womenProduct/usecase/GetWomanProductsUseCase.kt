package com.example.domain.features.womenProduct.usecase

import com.example.domain.features.womenProduct.model.WomanProduct
import com.example.domain.features.womenProduct.repository.WomanProductRepository
import javax.inject.Inject

class GetWomanProductsUseCase @Inject constructor(private val productRepository: WomanProductRepository) {
    suspend operator fun invoke(): List<WomanProduct?>? = productRepository.getProductsFromRemote()
}