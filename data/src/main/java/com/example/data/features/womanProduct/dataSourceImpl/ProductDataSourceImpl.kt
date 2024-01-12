package com.example.data.features.womanProduct.dataSourceImpl

import com.example.data.api.WebServices
import com.example.data.features.womanProduct.dataSourceContract.ProductDataSource
import com.example.domain.features.womenProduct.model.WomanProduct
import javax.inject.Inject

class ProductDataSourceImpl @Inject constructor(private val webServices: WebServices) :
    ProductDataSource {
    override suspend fun getProducts(): List<WomanProduct?>? {
        val response = webServices.getWomanProducts()
        return response.data?.map {
            it?.toWomanProduct()
        }
    }
}