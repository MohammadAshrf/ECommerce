package com.example.domain.features.mensProduct.usecase

import com.example.domain.features.mensProduct.model.MensProduct
import com.example.domain.features.mensProduct.repository.MensRepository
import javax.inject.Inject

class GetMensProductsUseCase @Inject constructor(private val menProductsRepository: MensRepository) {
    suspend operator fun invoke(): List<MensProduct?>? =
        menProductsRepository.getMenProductsFromRemote()
}