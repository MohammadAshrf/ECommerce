package com.example.domain.entity.product

data class Data(
    val _id: String,
    val availableColors: List<Any>,
    val brand: Any,
    val category: Category,
    val createdAt: String,
    val description: String,
    val id: String,
    val imageCover: String,
    val images: List<String>,
    val price: Int,
    val priceAfterDiscount: Int,
    val quantity: Int,
    val ratingsAverage: Double,
    val ratingsQuantity: Int,
    val slug: String,
    val sold: Int,
    val subcategory: List<Subcategory>,
    val title: String,
    val updatedAt: String
)