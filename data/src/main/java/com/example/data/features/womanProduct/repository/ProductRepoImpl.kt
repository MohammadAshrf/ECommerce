package com.example.data.features.womanProduct.repository

import com.example.data.features.womanProduct.dataSourceContract.ProductDataSource
import com.example.domain.features.womenProduct.model.WomanProduct
import com.example.domain.features.womenProduct.repository.WomanProductRepository
import javax.inject.Inject

class ProductRepoImpl @Inject
constructor(private val dataSource: ProductDataSource) : WomanProductRepository {
    override suspend fun getProductsFromRemote(): List<WomanProduct?>? = dataSource.getProducts()
}