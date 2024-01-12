package com.example.data.features.electronicProducts.dataSourceImpl

import com.example.data.api.WebServices
import com.example.data.features.electronicProducts.dataSourceContract.ElectronicProductsDataSource
import com.example.domain.features.electronicsProduct.model.ElectronicProducts
import javax.inject.Inject

class ElectronicProductsDataSourceImpl @Inject constructor(private val webServices: WebServices) :
    ElectronicProductsDataSource {
    override suspend fun getElectronicProducts(): List<ElectronicProducts?>? {
        val response = webServices.getElectronicProducts()
        return response.data?.map {
            it?.toElectronicsProduct()
        }
    }

}