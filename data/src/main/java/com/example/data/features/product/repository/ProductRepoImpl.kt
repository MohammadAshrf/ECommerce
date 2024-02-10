package com.example.data.features.product.repository

import com.example.data.features.product.dataSourceContract.ProductDataSource
import com.example.domain.features.product.model.Product
import com.example.domain.features.product.repository.ProductRepository
import javax.inject.Inject

class ProductRepoImpl @Inject
constructor(private val dataSource: ProductDataSource) : ProductRepository {
    override suspend fun getProductsFromRemote(): List<Product?>? = dataSource.getProducts()
}