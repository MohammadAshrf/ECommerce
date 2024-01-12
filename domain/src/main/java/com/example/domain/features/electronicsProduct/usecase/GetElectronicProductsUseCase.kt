package com.example.domain.features.electronicsProduct.usecase

import com.example.domain.features.electronicsProduct.model.ElectronicProducts
import com.example.domain.features.electronicsProduct.repository.ElectronicsRepository
import javax.inject.Inject

class GetElectronicProductsUseCase @Inject constructor(private val electronicsRepository: ElectronicsRepository) {
    suspend operator fun invoke(): List<ElectronicProducts?>? =
        electronicsRepository.getElectronicProductsFromRemote()
}