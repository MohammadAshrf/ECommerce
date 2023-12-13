package com.example.domain.entity.product

data class ProductResponse(
    val `data`: List<Data>,
    val metadata: Metadata,
    val results: Int
)