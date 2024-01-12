package com.example.data.features.menProducts.dataSourceImpl

import com.example.data.api.WebServices
import com.example.data.features.menProducts.dataSourceContract.MenProductsDataSource
import com.example.domain.features.mensProduct.model.MensProduct
import javax.inject.Inject

class MenProductsDataSourceImpl @Inject constructor(private val webServices: WebServices) :
    MenProductsDataSource {
    override suspend fun getMenProducts(): List<MensProduct?>? {
        val response = webServices.getMenProducts()
        return response.data?.map {
            it?.toMenProduct()
        }
    }
}