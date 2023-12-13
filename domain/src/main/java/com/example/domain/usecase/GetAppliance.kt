package com.example.domain.usecase

import com.example.domain.repositories.appliance.ApplianceRepository

class GetAppliance(private val applianceRepository: ApplianceRepository) {
    suspend operator fun invoke() = applianceRepository.getApplianceFromRemote()
}