package com.example.domain.entity.brand

data class BrandResponse(
    val `data`: List<Any>,
    val metadata: Metadata,
    val results: Int
)