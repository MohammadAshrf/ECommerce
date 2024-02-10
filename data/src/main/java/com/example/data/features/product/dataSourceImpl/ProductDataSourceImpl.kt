package com.example.data.features.product.dataSourceImpl

import com.example.data.api.WebServices
import com.example.data.features.product.dataSourceContract.ProductDataSource
import com.example.domain.features.product.model.Product
import javax.inject.Inject

class ProductDataSourceImpl @Inject constructor(private val webServices: WebServices) :
    ProductDataSource {
    override suspend fun getProducts(): List<Product?>? {
        val response = webServices.getWomanProducts()
        return response.data?.map {
            it?.toProduct()
        }
    }
}