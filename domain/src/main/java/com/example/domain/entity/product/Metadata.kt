package com.example.domain.entity.product

data class Metadata(
    val currentPage: Int,
    val limit: Int,
    val nextPage: Int,
    val numberOfPages: Int
)