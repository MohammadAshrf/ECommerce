package com.example.domain.entity.category

data class CategoryResponse(
    val `data`: List<Data>?,
    val metadata: Metadata?,
    val results: Int?
)