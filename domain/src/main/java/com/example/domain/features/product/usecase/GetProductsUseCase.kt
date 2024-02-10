package com.example.domain.features.product.usecase

import com.example.domain.features.product.model.Product
import com.example.domain.features.product.repository.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend operator fun invoke(): List<Product?>? = productRepository.getProductsFromRemote()
}