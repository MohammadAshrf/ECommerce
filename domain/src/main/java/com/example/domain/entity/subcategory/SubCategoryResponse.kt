package com.example.domain.entity.subcategory

data class SubCategoryResponse(
    val `data`: List<Data>,
    val metadata: Metadata,
    val results: Int
)